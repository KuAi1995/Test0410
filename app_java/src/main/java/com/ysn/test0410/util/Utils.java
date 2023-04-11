package com.ysn.test0410.util;

import android.content.Context;
import android.text.TextUtils;

/**
 * 项目名称：Test0410
 * 创建人：fulin
 * 创建时间：2023/4/11 21:15
 * 类描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
public class Utils {
    /**
     * @author fulin
     * @time 2023/4/11 21:27
     * @Description: 判断是否安装应用
     */
    public static boolean checkInstalled(Context context, String pkgName) {
        if (TextUtils.isEmpty(pkgName)) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(pkgName, 0);
        } catch (Exception x) {
            return false;
        }
        return true;
    }
}
