package com.example.aswanabidin.tubessisfo;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class HalamanTabbed extends AppCompatActivity {

    ImageView adduser;
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private Button btnLogout;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase data;
    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_tabbed);

        data = FirebaseDatabase.getInstance();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_halaman_tabbed, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        firebaseAuth = FirebaseAuth.getInstance();
        switch (item.getItemId()) {
            case R.id.btnLogout:
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(this, AfterSplash.class));
                break;

            case R.id.btnDaftarAnggota:
                finish();
                startActivity(new Intent(this, AnggotaFragment.class));

        }
        return super.onOptionsItemSelected(item);
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        private FirebaseDatabase data;
        private FirebaseAuth mAuth;
        private FirebaseUser user;


        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            data = FirebaseDatabase.getInstance();
            mAuth = FirebaseAuth.getInstance();
            user = mAuth.getCurrentUser();

            if (getArguments().getInt(ARG_SECTION_NUMBER) == 1) {
//                AdapterBeranda adapter;
//                ArrayList<ModelBeranda> databeranda = new ArrayList<>();
//                databeranda.add(new ModelBeranda("http://manfaat.co.id/wp-content/uploads/2014/08/buah-buahan-300x198.jpg","judul 1","ini des"));
//                databeranda.add(new ModelBeranda("http://blog.blanja.com/wp-content/uploads/2015/09/apel.jpg","judul 2","ini des1"));
//                databeranda.add(new ModelBeranda("http://blog.blanja.com/wp-content/uploads/2015/09/apel.jpg","judul 3","ini des2"));
//                databeranda.add(new ModelBeranda("http://blog.blanja.com/wp-content/uploads/2015/09/apel.jpg","judul 4","ini des3"));
                final View rootView = inflater.inflate(R.layout.fragment_beranda_page, container, false);
//                ListView list = (ListView) rootView.findViewById(R.id.listberanda);
//                adapter = new AdapterBeranda(databeranda,PlaceholderFragment.this.getContext());
//                list.setAdapter(adapter);
                String url = "http://kumpulan.info/sehat.html"; //pendefinisian url

                ImageView kesehatan = (ImageView) rootView.findViewById(R.id.thumbnail);
                kesehatan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent inten = new Intent(getActivity(), DetailView.class);
                        startActivity(inten);
                    }
                });

                return rootView;
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 2) {
                View rootView = inflater.inflate(R.layout.fragment_anggota, container, false);
//                AdapterAnggota adapter;
//                final ArrayList<Anggota> dataAnggota= new ArrayList<>();

//                ListView list = (ListView) rootView.findViewById(R.id.listanggota);
//                data.getReference().addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
//                            dataAnggota.add(postSnapshot.getValue(Anggota.class));
//                            Toast.makeText(PlaceholderFragment.this.getContext(), dataAnggota.get(0).getAnggotaNamaLengkap(), Toast.LENGTH_SHORT).show();
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//
//                    }
//                });
//                adapter = new AdapterAnggota(dataAnggota,PlaceholderFragment.this.getContext());
//                list.setAdapter(adapter);
//                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        Anggota a = dataAnggota.get(position);
//                        Intent i = new Intent(PlaceholderFragment.this.getActivity(),DetailAnggota.class);
//                        i.putExtra("anggota",a);
//                        startActivity(i);
//                    }
//                });
                return rootView;
//                final TextView anggota1 = (TextView) rootView.findViewById(R.id.textViewNomorKartuKeluarga);
//                data.getReference().addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
//                            //getting the data from snapshot
//                            Anggota anggota = postSnapshot.getValue(Anggota.class);
//                            if (anggota.getAnggotaId().equals(user.getUid())) {
//                                String nomorkartukeluarga = anggota.getAnggotaNomorKartuKeluarga();
//                                anggota1.setText(nomorkartukeluarga);
//                            }
//
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//
//                    }
//                });
//
//


            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 3) {
                View rootView = inflater.inflate(R.layout.fragment_mutasi_page, container, false);
                return rootView;
            } else {
                View rootView = inflater.inflate(R.layout.fragment_halaman_tabbed, container, false);
                TextView textView = (TextView) rootView.findViewById(R.id.section_label);
                textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
                return rootView;
            }
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            if (position == 1) {
                Fragment f = new AnggotaFragment();
                return f;
            } else
                return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "BERANDA";
                case 1:
                    return "ANGGOTA";
                case 2:
                    return "MUTASI";
                case 3:
                    return "TAGIHAN";
            }
            return null;
        }
    }
}
