package com.ysn.app_kotlin.util

import android.content.Context
import android.text.TextUtils
import java.lang.Exception

/**
 * 项目名称：Test0410
 * 创建人：fulin
 * 创建时间：2023/4/11 21:15
 * 类描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
object Utils {
    /**
     * @author fulin
     * @time 2023/4/11 21:27
     * @Description: 判断是否安装应用
     */
    fun checkInstalled(context: Context, pkgName: String?): Boolean {
        if (TextUtils.isEmpty(pkgName)) {
            return false
        }
        try {
            context.packageManager.getPackageInfo(pkgName!!, 0)
        } catch (x: Exception) {
            return false
        }
        return true
    }
}