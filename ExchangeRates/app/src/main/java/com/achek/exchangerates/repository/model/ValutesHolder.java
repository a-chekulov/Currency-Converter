package com.achek.exchangerates.repository.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ValutesHolder {

    @SerializedName("AUD")
    @Expose
    private Valute aUD;
    @SerializedName("AZN")
    @Expose
    private Valute aZN;
    @SerializedName("GBP")
    @Expose
    private Valute gBP;
    @SerializedName("AMD")
    @Expose
    private Valute aMD;
    @SerializedName("BYN")
    @Expose
    private Valute bYN;
    @SerializedName("BGN")
    @Expose
    private Valute bGN;
    @SerializedName("BRL")
    @Expose
    private Valute bRL;
    @SerializedName("HUF")
    @Expose
    private Valute hUF;
    @SerializedName("HKD")
    @Expose
    private Valute hKD;
    @SerializedName("DKK")
    @Expose
    private Valute dKK;
    @SerializedName("USD")
    @Expose
    private Valute uSD;
    @SerializedName("EUR")
    @Expose
    private Valute eUR;
    @SerializedName("INR")
    @Expose
    private Valute iNR;
    @SerializedName("KZT")
    @Expose
    private Valute kZT;
    @SerializedName("CAD")
    @Expose
    private Valute cAD;
    @SerializedName("KGS")
    @Expose
    private Valute kGS;
    @SerializedName("CNY")
    @Expose
    private Valute cNY;
    @SerializedName("MDL")
    @Expose
    private Valute mDL;
    @SerializedName("NOK")
    @Expose
    private Valute nOK;
    @SerializedName("PLN")
    @Expose
    private Valute pLN;
    @SerializedName("RON")
    @Expose
    private Valute rON;
    @SerializedName("XDR")
    @Expose
    private Valute xDR;
    @SerializedName("SGD")
    @Expose
    private Valute sGD;
    @SerializedName("TJS")
    @Expose
    private Valute tJS;
    @SerializedName("TRY")
    @Expose
    private Valute tRY;
    @SerializedName("TMT")
    @Expose
    private Valute tMT;
    @SerializedName("UZS")
    @Expose
    private Valute uZS;
    @SerializedName("UAH")
    @Expose
    private Valute uAH;
    @SerializedName("CZK")
    @Expose
    private Valute cZK;
    @SerializedName("SEK")
    @Expose
    private Valute sEK;
    @SerializedName("CHF")
    @Expose
    private Valute cHF;
    @SerializedName("ZAR")
    @Expose
    private Valute zAR;
    @SerializedName("KRW")
    @Expose
    private Valute kRW;
    @SerializedName("JPY")
    @Expose
    private Valute jPY;

    public ValutesHolder(Valute aUD, Valute aZN, Valute gBP, Valute aMD, Valute bYN, Valute bGN,
                         Valute bRL, Valute hUF, Valute hKD, Valute dKK, Valute uSD, Valute eUR,
                         Valute iNR, Valute kZT, Valute cAD, Valute kGS, Valute cNY, Valute mDL,
                         Valute nOK, Valute pLN, Valute rON, Valute xDR, Valute sGD, Valute tJS,
                         Valute tRY, Valute tMT, Valute uZS, Valute uAH, Valute cZK, Valute sEK,
                         Valute cHF, Valute zAR, Valute kRW, Valute jPY) {
        this.aUD = aUD;
        this.aZN = aZN;
        this.gBP = gBP;
        this.aMD = aMD;
        this.bYN = bYN;
        this.bGN = bGN;
        this.bRL = bRL;
        this.hUF = hUF;
        this.hKD = hKD;
        this.dKK = dKK;
        this.uSD = uSD;
        this.eUR = eUR;
        this.iNR = iNR;
        this.kZT = kZT;
        this.cAD = cAD;
        this.kGS = kGS;
        this.cNY = cNY;
        this.mDL = mDL;
        this.nOK = nOK;
        this.pLN = pLN;
        this.rON = rON;
        this.xDR = xDR;
        this.sGD = sGD;
        this.tJS = tJS;
        this.tRY = tRY;
        this.tMT = tMT;
        this.uZS = uZS;
        this.uAH = uAH;
        this.cZK = cZK;
        this.sEK = sEK;
        this.cHF = cHF;
        this.zAR = zAR;
        this.kRW = kRW;
        this.jPY = jPY;
    }

    public Valute getaUD() {
        return aUD;
    }

    public Valute getaZN() {
        return aZN;
    }

    public Valute getgBP() {
        return gBP;
    }

    public Valute getaMD() {
        return aMD;
    }

    public Valute getbYN() {
        return bYN;
    }

    public Valute getbGN() {
        return bGN;
    }

    public Valute getbRL() {
        return bRL;
    }

    public Valute gethUF() {
        return hUF;
    }

    public Valute gethKD() {
        return hKD;
    }

    public Valute getdKK() {
        return dKK;
    }

    public Valute getuSD() {
        return uSD;
    }

    public Valute geteUR() {
        return eUR;
    }

    public Valute getiNR() {
        return iNR;
    }

    public Valute getkZT() {
        return kZT;
    }

    public Valute getcAD() {
        return cAD;
    }

    public Valute getkGS() {
        return kGS;
    }

    public Valute getcNY() {
        return cNY;
    }

    public Valute getmDL() {
        return mDL;
    }

    public Valute getnOK() {
        return nOK;
    }


    public Valute getpLN() {
        return pLN;
    }


    public Valute getrON() {
        return rON;
    }


    public Valute getxDR() {
        return xDR;
    }


    public Valute getsGD() {
        return sGD;
    }


    public Valute gettJS() {
        return tJS;
    }


    public Valute gettRY() {
        return tRY;
    }


    public Valute gettMT() {
        return tMT;
    }


    public Valute getuZS() {
        return uZS;
    }


    public Valute getuAH() {
        return uAH;
    }


    public Valute getcZK() {
        return cZK;
    }


    public Valute getsEK() {
        return sEK;
    }


    public Valute getcHF() {
        return cHF;
    }


    public Valute getzAR() {
        return zAR;
    }


    public Valute getkRW() {
        return kRW;
    }


    public Valute getjPY() {
        return jPY;
    }

}
