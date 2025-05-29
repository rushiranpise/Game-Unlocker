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
    // Packages to Spoof as ROG Phone 6
    private static final String[] packagesToChangeROG6 = {
        "com.activision.callofduty.shooter",
        "com.activision.callofudty.warzone",
        "com.ea.gp.fifamobile",
        "com.gameloft.android.ANMP.GloftA9HM",
        "com.madfingergames.legends",
        "com.pearlabyss.blackdesertm",
        "com.pearlabyss.blackdesertm.gl"
    };

    // Packages to Spoof as Xperia 5
    private static final String[] packagesToChangeXP5 = {
        "com.garena.game.codm",
        "com.tencent.tmgp.kr.codm",
        "com.vng.codmvn",
        "com.garena.game.kgvn"
    };

    // Packages to Spoof as OnePlus 8 Pro
    private static final String[] packagesToChangeOP8P = {
        "com.netease.lztgglobal",
        "com.pubg.imobile",
        "com.pubg.krmobile",
        "com.rekoo.pubgm",
        "com.riotgames.league.wildrift",
        "com.riotgames.league.wildrifttw",
        "com.riotgames.league.wildriftvn",
        "com.riotgames.league.teamfighttactics",
        "com.riotgames.league.teamfighttacticstw",
        "com.riotgames.league.teamfighttacticsvn",
        "com.tencent.ig",
        "com.tencent.tmgp.pubgmhd",
        "com.vng.pubgmobile",
        "vng.games.revelation.mobile",
        "com.ngame.allstar.eu",
        "com.mojang.minecraftpe",
        "com.YoStar.AetherGazer",
        "com.miHoYo.GenshinImpact",
        "com.garena.game.lmjx"
    };

    // Packages to Spoof as OnePlus 9 Pro
    private static final String[] packagesToChangeOP9P = {
        "com.epicgames.fortnite",
        "com.epicgames.portal",
        "com.tencent.lolm",
        "jp.konami.pesam"
    };

    // Packages to Spoof as Mi 11T Pro
    private static final String[] packagesToChangeMI11TP = {
        "com.ea.gp.apexlegendsmobilefps",
        "com.mobilelegends.mi",
        "com.levelinfinite.hotta.gp",
        "com.supercell.clashofclans",
        "com.vng.mlbbvn"
    };

    // Packages to Spoof as Xiaomi 13 Pro
    private static final String[] packagesToChangeMI13P = {
        "com.levelinfinite.sgameGlobal",
        "com.tencent.tmgp.sgame"
    };

    // Packages to Spoof as POCO F5
    private static final String[] packagesToChangeF5 = {
        "com.dts.freefiremax",
        "com.dts.freefireth",
        "com.mobile.legends"
    };

    // Packages to Spoof as Black Shark 4
    private static final String[] packagesToChangeBS4 = {
        "com.proximabeta.mf.uamo"
    };

    // Packages to Spoof as iQOO 11 Pro
    private static final String[] packagesToChangeiQ11P = {
        "com.tencent.KiHan",
        "com.tencent.tmgp.cf",
        "com.tencent.tmgp.cod",
        "com.tencent.tmgp.gnyx"
    };

    // Packages to Spoof as GameMatrix
    private static final String[] packagesToChangeGameMatrix = {
        "com.proxima.dfm",
        "com.garena.game.df"
    };

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) {

        String packageName = loadPackageParam.packageName;

        // Asus
        if (Arrays.asList(packagesToChangeROG6).contains(packageName)) {
            propsToChangeROG6();
            XposedBridge.log("Spoofed " + packageName + " as Asus ROG 6");
        }

        // Black Shark
        if (Arrays.asList(packagesToChangeBS4).contains(packageName)) {
            propsToChangeBS4();
            XposedBridge.log("Spoofed " + packageName + " as Black Shark 4");
        }

        // Iqoo
        if (Arrays.asList(packagesToChangeiQ11P).contains(packageName)) {
            propsToChangeiQ11P();
            XposedBridge.log("Spoofed " + packageName + " as iQOO 11 Pro");
        }

        // OnePlus
        if (Arrays.asList(packagesToChangeOP8P).contains(packageName)) {
            propsToChangeOP8P();
            XposedBridge.log("Spoofed " + packageName + " as OnePlus 8 Pro");
        }

        if (Arrays.asList(packagesToChangeOP9P).contains(packageName)) {
            propsToChangeOP9P();
            XposedBridge.log("Spoofed " + packageName + " as OnePlus 9 Pro");
        }

        // Poco
        if (Arrays.asList(packagesToChangeF5).contains(packageName)) {
            propsToChangeF5();
            XposedBridge.log("Spoofed " + packageName + " as Poco F5");
        }

        // Sony
        if (Arrays.asList(packagesToChangeXP5).contains(packageName)) {
            propsToChangeXP5();
            XposedBridge.log("Spoofed " + packageName + " as Sony Xperia 5");
        }

        // Xiaomi
        if (Arrays.asList(packagesToChangeMI11TP).contains(packageName)) {
            propsToChangeMI11TP();
            XposedBridge.log("Spoofed " + packageName + " as Xiaomi Mi 11T Pro");
        }

        if (Arrays.asList(packagesToChangeMI13P).contains(packageName)) {
            propsToChangeMI13P();
            XposedBridge.log("Spoofed " + packageName + " as Xiaomi Mi 13 Pro");
        }

        // GameMatrix
        if (Arrays.asList(packagesToChangeGameMatrix).contains(packageName)) {
            propsToChangeGameMatrix();
            XposedBridge.log("Spoofed " + packageName + " as GameMatrix");
        }
    }

    // Asus
    // Props to Spoof as Asus Rog 6
    private static void propsToChangeROG6() {
        setPropValue("BRAND", "asus");
        setPropValue("MANUFACTURER", "asus");
        setPropValue("DEVICE", "AI2201");
        setPropValue("MODEL", "ASUS_AI2201");
    }

    // Blackshark
    // Props to Spoof as Blackshark 4
    private static void propsToChangeBS4() {
        setPropValue("MANUFACTURER", "blackshark");
        setPropValue("MODEL", "2SM-X706B");
    }

    // Iqoo
    // Props to Spoof as iQOO 11 Pro
    private static void propsToChangeiQ11P() {
        setPropValue("MANUFACTURER", "vivo");
        setPropValue("MODEL", "V2243A");
    }

    // OnePlus
    // Props to Spoof as OnePlus 8 Pro
    private static void propsToChangeOP8P() {
        setPropValue("MANUFACTURER", "OnePlus");
        setPropValue("MODEL", "IN2020");
    }

    // Props to Spoof as OnePlus 9 Pro
    private static void propsToChangeOP9P() {
        setPropValue("MANUFACTURER", "OnePlus");
        setPropValue("MODEL", "LE2123");
    }

    //Poco
    // Props to Spoof as Poco F5
    private static void propsToChangeF5() {
        setPropValue("MANUFACTURER", "Xiaomi");
        setPropValue("MODEL", "23049PCD8G");
    }

    // Sony
    // Props to Spoof as Sony Xperia 5
    private static void propsToChangeXP5() {
        setPropValue("MANUFACTURER", "Sony");
        setPropValue("MODEL", "SO-52A");
    }

    // Xiaomi
    // Props to Spoof as Xiaomi Mi 11T Pro
    private static void propsToChangeMI11TP() {
        setPropValue("MANUFACTURER", "Xiaomi");
        setPropValue("MODEL", "2107113SI");
    }

    // Props to Spoof as Xiaomi Mi 13 Pro
    private static void propsToChangeMI13P() {
        setPropValue("MANUFACTURER", "Xiaomi");
        setPropValue("MODEL", "2210132C");
    }

    // Props to Spoof as GameMatrix
    private static void propsToChangeGameMatrix() {
        setPropValue("MODEL", "gamematrix");
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
