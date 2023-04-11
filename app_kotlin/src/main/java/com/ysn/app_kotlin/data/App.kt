package com.ysn.app_kotlin.data

/**
 * 项目名称：Test0409
 * 创建人：fulin
 * 创建时间：2023/4/9 14:56
 * 类描述：app实体类
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
class App {
    @JvmField
    var imagePath // 应用图标地址
            : String? = null
    var packageName // 包名
            : String? = null
    @JvmField
    var appName // 应用名称
            : String? = null
    @JvmField
    var appSize // 应用大小
            = 0.0
    var versionCode // 版本号
            = 0
    @JvmField
    var versionName // 版本名
            : String? = null
    var apkUrl // app链接
            : String? = null
    @JvmField
    var timeUpdate // 更新时间
            : String? = null
    @JvmField
    var appIntroduction // 介绍
            : String? = null
}