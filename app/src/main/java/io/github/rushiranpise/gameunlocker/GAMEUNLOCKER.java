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
    private static final String[] PACKAGE_ROG1 = {"com.madfingergames.legends"};
    private static final String[] PACKAGE_ROG3 = {"com.pearlabyss.blackdesertm","com.pearlabyss.blackdesertm.gl"};
    private static final String[] PACKAGE_OP8P = {"com.miHoYo.GenshinImpact", "com.netease.lztgglobal","com.pubg.krmobile","com.rekoo.pubgm","com.riotgames.league.wildrift","com.riotgames.league.wildrifttw","com.riotgames.league.wildriftvn","com.tencent.tmgp.pubgmhd","com.vng.pubgmobile"};
    private static final String[] PACKAGE_OP9R = {"com.epicgames.fortnite","com.epicgames.portal"};
    private static final String[] PACKAGE_M11TP = {"com.ea.gp.apexlegendsmobilefps","com.levelinfinite.hotta.gp","com.mobile.legends","com.mobilelegends.mi","com.supercell.clashofclans","com.vng.mlbbvn"};
    private static final String[] PACKAGE_ROG6 = {"com.ea.gp.fifamobile","com.gameloft.android.ANMP.GloftA9HM"};
    private static final String[] PACKAGE_OP9P = {"com.tencent.lolm"};
    // private static final String[] PACKAGE_M13TP = {"com.levelinfinite.sgameGlobal"};
    private static final String[] PACKAGE_F5 = {"com.dts.freefiremax","com.dts.freefireth"};
    private static final String[] PACKAGE_NEO7 = {"com.pubg.imobile"};
    private static final String[] PACKAGE_M11U = {"com.tencent.ig"};
    private static final String[] PACKAGE_Y700 = {"com.vng.codmvn","com.activision.callofduty.shooter","com.garena.game.codm","com.tencent.tmgp.kr.codm"};
    private static final String[] PACKAGE_V2254A = {"com.tencent.tmgp.sgame","com.levelinfinite.sgameGlobal"};

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) {

        String packageName = loadPackageParam.packageName;
        
        if (Arrays.asList(PACKAGE_ROG1).contains(packageName)) {
            ROG1();
            XposedBridge.log("Spoofed" + packageName + " as Asus ROG 1");

        }

        if (Arrays.asList(PACKAGE_ROG3).contains(packageName)) {
            ROG3();
            XposedBridge.log("Spoofed" + packageName + " as Asus ROG 3");

        }

        if (Arrays.asList(PACKAGE_OP8P).contains(packageName)) {
            OP8P();
            XposedBridge.log("Spoofed" + packageName + " as OnePlus 8 Pro");

        }

        if (Arrays.asList(PACKAGE_OP9R).contains(packageName)) {
            OP9RP();
            XposedBridge.log("Spoofed" + packageName + " as OnePlus 9R");

        }

        if (Arrays.asList(PACKAGE_M11TP).contains(packageName)) {
            M11TP();
            XposedBridge.log("Spoofed" + packageName + " as Mi 11T Pro");

        }

        if (Arrays.asList(PACKAGE_ROG6).contains(packageName)) {
            ROG6();
            XposedBridge.log("Spoofed" + packageName + " as Asus ROG 6");
 
        }

        if (Arrays.asList(PACKAGE_OP9P).contains(packageName)) {
            OP9P();
            XposedBridge.log("Spoofed" + packageName + " as OnePlus 9 Pro");

        }

        // if (Arrays.asList(PACKAGE_M13TP).contains(packageName)) {
        //     M13TP();
        //     XposedBridge.log("Spoofed" + packageName + " as  Mi 13T Pro");

        // }

        if (Arrays.asList(PACKAGE_F5).contains(packageName)) {
            POCOF5();
            XposedBridge.log("Spoofed" + packageName + " as Poco F5");

        }

        if (Arrays.asList(PACKAGE_NEO7).contains(packageName)) {
            NEO7();
            XposedBridge.log("Spoofed" + packageName + " as iQOO Neo 7");

        }

        if (Arrays.asList(PACKAGE_M11U).contains(packageName)) {
            M11U();
            XposedBridge.log("Spoofed" + packageName + " as Mi 11 Ultra");

        }

        if (Arrays.asList(PACKAGE_Y700).contains(packageName)) {
            Y700();
            XposedBridge.log("Spoofed" + packageName + " as Lenovo Legion Y700");

        }

        if (Arrays.asList(PACKAGE_V2254A).contains(packageName)) {
            V2254A();
            XposedBridge.log("Spoofed" + packageName + " as iQOO 11 Pro");

        }
        
    }

    private static void ROG1() {
        setBuildField("MANUFACTURER", "Asus");
        setBuildField("MODEL", "ASUS_AI2201");
    }
    
    private static void ROG3() {
        setBuildField("MANUFACTURER", "Asus");
        setBuildField("MODEL", "ASUS_I003D");
    }
    
    private static void XP5() {
        setBuildField("MANUFACTURER", "Sony");
        setBuildField("MODEL", "SO-52A");
    }

    private static void OP8P() {
        setBuildField("MANUFACTURER", "OnePlus");
        setBuildField("MODEL", "IN2023");
    }

    private static void OP9RP() {
        setBuildField("MANUFACTURER", "OnePlus");
        setBuildField("MODEL", "LE2101");
    }

    private static void M11TP() {
        setBuildField("MANUFACTURER", "Xiaomi");
        setBuildField("MODEL", "21081111RG");
    }

    private static void POCOF4() {
        setBuildField("MANUFACTURER", "Xiaomi");
        setBuildField("MODEL", "22021211RG");
    }

    private static void ROG6() {
        setBuildField("BRAND", "asus");
        setBuildField("MANUFACTURER", "asus");
        setBuildField("DEVICE", "AI2201");
        setBuildField("MODEL", "ASUS_AI2201");
    }

   private static void OP9P() {
        setBuildField("MANUFACTURER", "OnePlus");
        setBuildField("MODEL", "LE2123");
    }

    // private static void M13TP() {
    //     setBuildField("BRAND", "Xiaomi");
    //     setBuildField("MANUFACTURER", "Xiaomi");
    //     setBuildField("MODEL", "2210132C");
    // }

    private static void POCOF5() {
        setBuildField("MANUFACTURER", "Xiaomi");
        setBuildField("MODEL", "23049PCD8G");
    }

    private static void NEO7() {
        setBuildField("MANUFACTURER", "iQOO");
        setBuildField("MODEL", "I2214");
    }

    private static void M11U() {
        setBuildField("MANUFACTURER", "Xiaomi");
        setBuildField("MODEL", "M2102K1G");
    }

    private static void Y700() {
        setBuildField("MANUFACTURER", "lenovo");
        setBuildField("MODEL", "Lenovo TB-9707F");
    }

    private static void V2254A() {
        setBuildField("MANUFACTURER", "vivo");
        setBuildField("MODEL", "V2254A");
    }

    private static void setBuildField(String key, String value) {
        try {
            // Unlock
            Field field = Build.class.getDeclaredField(key);
            field.setAccessible(true);
            // Edit
            field.set(null, value);
            // Lock
            field.setAccessible(false);
            
            Log.d(TAG, "Spoofed" + key + " with value: " + value);
            
        } catch (NoSuchFieldException | IllegalAccessException e) {
            Log.e(TAG, "Failed to spoof App." + key, e);
        }
    }

}
