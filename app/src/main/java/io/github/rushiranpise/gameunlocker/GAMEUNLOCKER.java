package io.github.rushiranpise.gameunlocker;

import android.annotation.SuppressLint;
import android.os.Build;
import android.util.Log;

import java.lang.reflect.Field;
import java.security.KeyStore;
import java.util.Arrays;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

@SuppressLint("DiscouragedPrivateApi")
@SuppressWarnings("ConstantConditions")
public class GAMEUNLOCKER implements IXposedHookLoadPackage {

    private static final String TAG = GAMEUNLOCKER.class.getSimpleName();
    // Packages to Spoof as Asus Rog 1
    private static final String[] PACKAGE_ROG1 = {
        "com.madfingergames.legends"
    };
    // Packages to Spoof as Asus Rog 3
    private static final String[] PACKAGE_ROG3 = {
        "com.pearlabyss.blackdesertm",
        "com.pearlabyss.blackdesertm.gl"
    };
    // Packages to Spoof as Asus Rog 6
    private static final String[] PACKAGE_ROG6 = {
        "com.epicgames.fortnite",
        "com.ea.gp.fifamobile",
        "com.gameloft.android.ANMP.GloftA9HM"
    };

    // Packages to Spoof as iQOO Neo 7
    private static final String[] PACKAGE_NEO7 = {
        "com.pubg.imobile"
    };
    // Packages to Spoof as iQOO 11 Pro
    private static final String[] PACKAGE_V2254A = {
        "com.tencent.tmgp.sgame",
        "com.levelinfinite.sgameGlobal",
        "com.mojang.minecraftpe"
    };

    // Packages to Spoof as Nubia Red Magic 8 Pro
    private static final String[] PACKAGE_NX729J = {
        "com.YoStar.AetherGazer"
    };

    // Packages to Spoof as Poco F5
    private static final String[] PACKAGE_F5 = {
        "com.dts.freefiremax",
        "com.dts.freefireth"
    };

    // Packages to Spoof as OnePlus 8 Pro
    private static final String[] PACKAGE_OP8P = {
        "com.miHoYo.GenshinImpact",
        "com.netease.lztgglobal",
        "com.pubg.krmobile",
        "com.rekoo.pubgm",
        "com.tencent.tmgp.pubgmhd",
        "com.vng.pubgmobile"
    };
    // Packages to Spoof as OnePlus 9 Pro
    private static final String[] PACKAGE_OP9P = {
        "jp.konami.pesam",
        "com.epicgames.portal",
        "com.riotgames.league.wildrift",
        "com.riotgames.league.wildrifttw",
        "com.riotgames.league.wildriftvn",
        "com.tencent.lolm"
    };

    // Packages to Spoof as Samsung Galaxy S23 Ultra
    private static final String[] PACKAGE_DM3Q = {
        "com.vng.codmvn",
        "com.activision.callofduty.shooter",
        "com.garena.game.codm",
        "com.tencent.tmgp.kr.codm",
        "com.garena.game.kgvn"
    };

    // Packages to Spoof as Xiaomi Mi 11T Pro
    private static final String[] PACKAGE_M11TP = {
        "com.ea.gp.apexlegendsmobilefps",
        "com.levelinfinite.hotta.gp",
        "com.mobile.legends",
        "com.mobilelegends.mi",
        "com.supercell.clashofclans",
        "com.vng.mlbbvn",
        "com.tencent.ig"
    };

    // Packages to Spoof as Black Shark 4
    private static final String[] PACKAGE_BS4 = {
        "com.proximabeta.mf.uamo"
    };

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) {

        String packageName = loadPackageParam.packageName;

        // Asus
        if (Arrays.asList(PACKAGE_ROG1).contains(packageName)) {
            ROG1();
            XposedBridge.log("Spoofed " + packageName + " as Asus ROG 1");
        }
        if (Arrays.asList(PACKAGE_ROG3).contains(packageName)) {
            ROG3();
            XposedBridge.log("Spoofed " + packageName + " as Asus ROG 3");
        }
        if (Arrays.asList(PACKAGE_ROG6).contains(packageName)) {
            ROG6();
            XposedBridge.log("Spoofed " + packageName + " as Asus ROG 6");
        }

        // Blackshark
        if (Arrays.asList(PACKAGE_BS4).contains(packageName)) {
            BS4();
            XposedBridge.log("Spoofed " + packageName + " as Blackshark 4");
        }

        // iQOO
        if (Arrays.asList(PACKAGE_NEO7).contains(packageName)) {
            NEO7();
            XposedBridge.log("Spoofed " + packageName + " as iQOO Neo 7");
        }
        if (Arrays.asList(PACKAGE_V2254A).contains(packageName)) {
            V2254A();
            XposedBridge.log("Spoofed " + packageName + " as iQOO 11 Pro");
        }

        // Nubia 
        if (Arrays.asList(PACKAGE_NX729J).contains(packageName)) {
            NX729J();
            XposedBridge.log("Spoofed " + packageName + " as Nubia Red Magic 8 Pro");
        }

        // OnePlus
        if (Arrays.asList(PACKAGE_OP8P).contains(packageName)) {
            OP8P();
            XposedBridge.log("Spoofed " + packageName + " as OnePlus 8 Pro");
        }
        if (Arrays.asList(PACKAGE_OP9P).contains(packageName)) {
            OP9P();
            XposedBridge.log("Spoofed " + packageName + " as OnePlus 9 PRO");
        }

        // Poco
        if (Arrays.asList(PACKAGE_F5).contains(packageName)) {
            POCOF5();
            XposedBridge.log("Spoofed " + packageName + " as Poco F5");
        }

        // Samsung
        if (Arrays.asList(PACKAGE_DM3Q).contains(packageName)) {
            DM3Q();
            XposedBridge.log("Spoofed " + packageName + " as Samsung Galaxy S23 Ultra");
        }

        // Xiaomi
        if (Arrays.asList(PACKAGE_M11TP).contains(packageName)) {
            M11TP();
            XposedBridge.log("Spoofed " + packageName + " as Xiaomi Mi 11T Pro");
        }
    }

    // Asus
    // Props to Spoof as Asus Rog 1
    private static void ROG1() {
        setPropValue("MANUFACTURER", "Asus");
        setPropValue("MODEL", "ASUS_AI2201");
    }
    // Props to Spoof as Asus Rog 3
    private static void ROG3() {
        setPropValue("MANUFACTURER", "Asus");
        setPropValue("MODEL", "ASUS_I003D");
    }
    // Props to Spoof as Asus Rog 6
    private static void ROG6() {
        setPropValue("BRAND", "asus");
        setPropValue("MANUFACTURER", "asus");
        setPropValue("DEVICE", "AI2201");
        setPropValue("MODEL", "ASUS_AI2201");
    }

    // Blackshark
    // Props to Spoof as Blackshark 4
    private static void BS4() {
        setPropValue("MANUFACTURER", "blackshark");
        setPropValue("MODEL", "2SM-X706B");
    }

    // iQOO
    // Props to Spoof as iQOO Neo 7
    private static void NEO7() {
        setPropValue("MANUFACTURER", "iQOO");
        setPropValue("MODEL", "I2214");
    }
    // Props to Spoof as iQOO 11 Pro
    private static void V2254A() {
        setPropValue("MANUFACTURER", "vivo");
        setPropValue("MODEL", "V2254A");
    }

    // Nubia
    // Props to Spoof as Nubia Red Magic 8 Pro
    private static void NX729J() {
        setPropValue("BRAND", "nubia");
        setPropValue("MANUFACTURER", "nubia");
        setPropValue("DEVICE", "NX729J");
        setPropValue("MODEL", "NX729J");
    }

    // Lenovo
    // Props to Spoof as Lenovo Legion Y700
    private static void Y700() {
        setPropValue("MANUFACTURER", "lenovo");
        setPropValue("MODEL", "Lenovo TB-9707F");
    }

    // OnePlus
    // Props to Spoof as OnePlus 8 Pro
    private static void OP8P() {
        setPropValue("BRAND", "OnePlus");
        setPropValue("MANUFACTURER", "OnePlus");
        setPropValue("DEVICE", "OnePlus8Pro");
        setPropValue("MODEL", "IN2020");
    }
    // Props to Spoof as OnePlus 9 Pro
    private static void OP9P() {
        setPropValue("BRAND", "OnePlus");
        setPropValue("MANUFACTURER", "OnePlus");
        setPropValue("DEVICE", "OnePlus9Pro");
        setPropValue("PRODUCT", "OnePlus9Pro_EEA");
        setPropValue("MODEL", "LE2123");
    }

    //Poco
    // Props to Spoof as Poco F5
    private static void POCOF5() {
        setPropValue("BRAND", "Xiaomi");
        setPropValue("MANUFACTURER", "Xiaomi");
        setPropValue("MODEL", "23049PCD8G");
    }

    // Samsung
    // Props to Spoof as Samsung S23 Ultra
    private static void DM3Q() {
        setPropValue("BRAND", "Samsung");
        setPropValue("MANUFACTURER", "Samsung");
        setPropValue("DEVICE", "dm3q");
        setPropValue("MODEL", "SM-S918B");
    }

    // Xiaomi
    // Props to Spoof as Xiaomi Mi 11T Pro
    private static void M11TP() {
        setPropValue("BRAND", "Xiaomi");
        setPropValue("MANUFACTURER", "Xiaomi");
        setPropValue("MODEL", "21081111RG");
    }
    // Props to Spoof as Xiaomi Mi 11 Ultra
    private static void M11U() {
        setPropValue("BRAND", "Xiaomi");
        setPropValue("MANUFACTURER", "Xiaomi");
        setPropValue("MODEL", "M2102K1G");
    }

    private static void setPropValue(String key, Object value) {
        try {
            Log.d(TAG, "Defining prop " + key + " to " + value.toString());
            Field field = Build.class.getDeclaredField(key);
            field.setAccessible(true);
            field.set(null, value);
            field.setAccessible(false);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            XposedBridge.log("Failed to set prop: " + key + "\n" + Log.getStackTraceString(e));
        }
    }
}