package com.crystallake.statusbarutil;

import com.crystallake.statusbarutil.compat.OsCompat;
import com.crystallake.statusbarutil.compat.OsCompatDef;
import com.crystallake.statusbarutil.compat.OsCompatFlyme;
import com.crystallake.statusbarutil.compat.OsCompatMiui;
import com.crystallake.statusbarutil.compat.OsCompatOppo;
import com.crystallake.statusbarutil.utils.OsUtils;

class OsCompatHolder {

    private static OsCompat sOsCompat = null;

    static OsCompat create() {
        if (sOsCompat == null) {
            if (OsUtils.isMiui()) {
                sOsCompat = new OsCompatMiui();
            } else if (OsUtils.isFlyme()) {
                sOsCompat = new OsCompatFlyme();
            } else if (OsUtils.isOppo()) {
                sOsCompat = new OsCompatOppo();
            } else {
                sOsCompat = new OsCompatDef();
            }
        }
        return sOsCompat;
    }
}