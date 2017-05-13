package com.example.aswanabidin.tubessisfo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by aswanabidin on 4/25/17.
 */

public class Anggota implements Parcelable {

    public static final Creator<Anggota> CREATOR = new Creator<Anggota>() {
        @Override
        public Anggota createFromParcel(Parcel in) {
            return new Anggota(in);
        }

        @Override
        public Anggota[] newArray(int size) {
            return new Anggota[size];
        }
    };
    String anggotaId;
    String anggotaNomorKartuKeluarga;
    String anggotaNomorRekening;
    String anggotaNamaLengkap;
    String anggotaTempatLahir;
    String anggotaTanggalLahir;
    String anggotaAlamatRumah;
    String anggotaJenisKelamin;
    String anggotaStatusPernikahan;
    String anggotaNomorTelepon;
    String anggotaAlamatEmail;
    String anggotaFasilitasKesehatan;


    public Anggota() {

    }


    public Anggota(String anggotaId, String anggotaNomorKartuKeluarga, String anggotaNomorRekening, String anggotaNamaLengkap, String anggotaTempatLahir, String anggotaTanggalLahir, String anggotaAlamatRumah, String anggotaJenisKelamin, String anggotaStatusPernikahan, String anggotaNomorTelepon, String anggotaAlamatEmail, String anggotaFasilitasKesehatan) {
        this.anggotaId = anggotaId;
        this.anggotaNomorKartuKeluarga = anggotaNomorKartuKeluarga;
        this.anggotaNomorRekening = anggotaNomorRekening;
        this.anggotaNamaLengkap = anggotaNamaLengkap;
        this.anggotaTempatLahir = anggotaTempatLahir;
        this.anggotaTanggalLahir = anggotaTanggalLahir;
        this.anggotaAlamatRumah = anggotaAlamatRumah;
        this.anggotaJenisKelamin = anggotaJenisKelamin;
        this.anggotaStatusPernikahan = anggotaStatusPernikahan;
        this.anggotaNomorTelepon = anggotaNomorTelepon;
        this.anggotaAlamatEmail = anggotaAlamatEmail;
        this.anggotaFasilitasKesehatan = anggotaFasilitasKesehatan;
    }

    protected Anggota(Parcel in) {
        anggotaId = in.readString();
        anggotaNomorKartuKeluarga = in.readString();
        anggotaNomorRekening = in.readString();
        anggotaNamaLengkap = in.readString();
        anggotaTempatLahir = in.readString();
        anggotaTanggalLahir = in.readString();
        anggotaAlamatRumah = in.readString();
        anggotaJenisKelamin = in.readString();
        anggotaStatusPernikahan = in.readString();
        anggotaNomorTelepon = in.readString();
        anggotaAlamatEmail = in.readString();
        anggotaFasilitasKesehatan = in.readString();
    }

    public String getAnggotaId() {
        return anggotaId;
    }

    public void setAnggotaId(String anggotaId) {
        this.anggotaId = anggotaId;
    }

    public String getAnggotaNomorKartuKeluarga() {
        return anggotaNomorKartuKeluarga;
    }

    public void setAnggotaNomorKartuKeluarga(String anggotaNomorKartuKeluarga) {
        this.anggotaNomorKartuKeluarga = anggotaNomorKartuKeluarga;
    }

    public String getAnggotaNamaLengkap() {
        return anggotaNamaLengkap;
    }

    public void setAnggotaNamaLengkap(String anggotaNamaLengkap) {
        this.anggotaNamaLengkap = anggotaNamaLengkap;
    }

    public String getAnggotaTempatLahir() {
        return anggotaTempatLahir;
    }

    public void setAnggotaTempatLahir(String anggotaTempatLahir) {
        this.anggotaTempatLahir = anggotaTempatLahir;
    }

    public String getAnggotaTanggalLahir() {
        return anggotaTanggalLahir;
    }

    public void setAnggotaTanggalLahir(String anggotaTanggalLahir) {
        this.anggotaTanggalLahir = anggotaTanggalLahir;
    }

    public String getAnggotaAlamatRumah() {
        return anggotaAlamatRumah;
    }

    public void setAnggotaAlamatRumah(String anggotaAlamatRumah) {
        this.anggotaAlamatRumah = anggotaAlamatRumah;
    }

    public String getAnggotaJenisKelamin() {
        return anggotaJenisKelamin;
    }

    public void setAnggotaJenisKelamin(String anggotaJenisKelamin) {
        this.anggotaJenisKelamin = anggotaJenisKelamin;
    }

    public String getAnggotaStatusPernikahan() {
        return anggotaStatusPernikahan;
    }

    public void setAnggotaStatusPernikahan(String anggotaStatusPernikahan) {
        this.anggotaStatusPernikahan = anggotaStatusPernikahan;
    }

    public String getAnggotaNomorTelepon() {
        return anggotaNomorTelepon;
    }

    public void setAnggotaNomorTelepon(String anggotaNomorTelepon) {
        this.anggotaNomorTelepon = anggotaNomorTelepon;
    }

    public String getAnggotaAlamatEmail() {
        return anggotaAlamatEmail;
    }

    public void setAnggotaAlamatEmail(String anggotaAlamatEmail) {
        this.anggotaAlamatEmail = anggotaAlamatEmail;
    }

    public String getAnggotaFasilitasKesehatan() {
        return anggotaFasilitasKesehatan;
    }

    public void setAnggotaFasilitasKesehatan(String anggotaFasilitasKesehatan) {
        this.anggotaFasilitasKesehatan = anggotaFasilitasKesehatan;
    }

    public String getAnggotaNomorRekening() {
        return anggotaNomorRekening;
    }

    public void setAnggotaNomorRekening(String anggotaNomorRekening) {
        this.anggotaNomorRekening = anggotaNomorRekening;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(anggotaId);
        dest.writeString(anggotaNomorKartuKeluarga);
        dest.writeString(anggotaNamaLengkap);
        dest.writeString(anggotaTempatLahir);
        dest.writeString(anggotaTanggalLahir);
        dest.writeString(anggotaAlamatRumah);
        dest.writeString(anggotaJenisKelamin);
        dest.writeString(anggotaStatusPernikahan);
        dest.writeString(anggotaNomorTelepon);
        dest.writeString(anggotaAlamatEmail);
        dest.writeString(anggotaFasilitasKesehatan);
    }
}
