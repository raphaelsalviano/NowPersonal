package br.com.ufpb.nowpersonal.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileSettingDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import java.sql.SQLException;

import br.com.ufpb.nowpersonal.NowPersonalApplication;
import br.com.ufpb.nowpersonal.R;
import br.com.ufpb.nowpersonal.model.Usuario;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Toolbar toolbar;

    private Usuario usuario;
    private NowPersonalApplication application;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        application = (NowPersonalApplication) getApplicationContext();

        try{
            usuario = application.searchUserByStatus();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        createDrawer(savedInstanceState);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        createMarker();

        // Add a marker in Sydney and move the camera
        Location location = application.getLocation();
        LatLng sydney = new LatLng(location.getLatitude(), location.getLongitude());
        CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(20).build();
        mMap.addMarker(new MarkerOptions().position(sydney).title(usuario.getNome() + " " + usuario.getSobrenome())
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_user)));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

    private void createMarker(){
        try{
            Log.i("user", "" + application.searchAllPersonal().size());
            if(application.searchAllPersonal().size() > 0){
                for (Usuario usuario : application.searchAllPersonal()){
                    LatLng lng = new LatLng(usuario.getEndereco().getLatitude(), usuario.getEndereco().getLongitude());
                    MarkerOptions options = new MarkerOptions();
                    options.position(lng).title(usuario.getNome() + " " + usuario.getSobrenome()).visible(true);
                    options.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_personal));
                    mMap.addMarker(new MarkerOptions()).setVisible(true);

                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void createDrawer(Bundle savedInstanceState){
        AccountHeader accountHeader = new AccountHeaderBuilder().withActivity(this)
                .withCompactStyle(false)
                .withSavedInstance(savedInstanceState)
                .withHeaderBackground(R.color.md_amber_700)
                .addProfiles(
                        new ProfileDrawerItem().withIcon(R.drawable.ic_people)
                                .withName("" + usuario.getNome() + " " + usuario.getSobrenome())
                                .withEmail("" + usuario.getEmail())
                                .withTypeface(createTypeface()).withIdentifier(0),

                        new ProfileSettingDrawerItem().withIcon(R.drawable.ic_settings)
                                .withName(getString(R.string.header_settings)).withTypeface(createTypeface())
                                .withIdentifier(1)
                )
                .withOnAccountHeaderListener(new AccountHeaderListener())
                .build();

        new DrawerBuilder().withActivity(this)
                .withActionBarDrawerToggleAnimated(true)
                .withDrawerGravity(Gravity.START)
                .withToolbar(toolbar)
                .withAccountHeader(accountHeader)
                .withItemAnimator(new DefaultItemAnimator())
                .withSelectedItem(-1)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Meu PIN: " + usuario.getPin())
                                .withIcon(R.drawable.ic_key_user)
                                .withTag("pin")
                )
                .addDrawerItems(new DividerDrawerItem()
                )
                .addDrawerItems(new PrimaryDrawerItem().withName("Ajuda")
                        .withIcon(R.drawable.ic_help_circle)
                        .withTag("help")
                )
                .addDrawerItems(new DividerDrawerItem()
                )
                .addDrawerItems(new PrimaryDrawerItem().withName("Sair")
                        .withIcon(R.drawable.ic_logout)
                        .withTag("logoff")
                )
                .withOnDrawerItemClickListener(new DrawerListener())
                .build();
    }

    private Typeface createTypeface(){
        return Typeface.createFromAsset(getAssets(), "fonts/roboto_medium.ttf");
    }

    private class AccountHeaderListener implements AccountHeader.OnAccountHeaderListener {

        @Override
        public boolean onProfileChanged(View view, IProfile profile, boolean current) {

            int id = profile.getIdentifier();

            if(id == 1){
                Intent intent = new Intent(MapsActivity.this, SettingsActivity.class);
                startActivity(intent);
                finish();
            }

            return false;
        }
    }

    private class DrawerListener implements Drawer.OnDrawerItemClickListener {

        @Override
        public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

            String TAG = drawerItem.getTag().toString();

            Intent intent = null;

            switch (TAG){
                case "pin":
                    new AlertDialog.Builder(MapsActivity.this)
                            .setTitle("O código PIN: " + usuario.getPin())
                            .setMessage("Este é seu código PIN, ele serve como chave de segurança para as configurações de conta e de aplicativos!" +
                                    "Ele é único e instranferível")
                            .setPositiveButton("OK", null)
                            .create().show();
                    return true;
                case "help":
                    intent = new Intent(MapsActivity.this, AboutActivity.class);
                    startActivity(intent);
                    finish();
                    return true;
                case "logoff":
                    try {
                        usuario.setStatus(false);
                        application.addOrUpdateUsuario(usuario);
                        intent = new Intent(MapsActivity.this, SlideActivity.class);
                        startActivity(intent);
                        finish();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return true;
            }

            return false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.myLocation_action){
            Location location = application.getLocation();
            LatLng sydney = new LatLng(location.getLatitude(), location.getLongitude());
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 25));

        }

        return super.onOptionsItemSelected(item);
    }
}
