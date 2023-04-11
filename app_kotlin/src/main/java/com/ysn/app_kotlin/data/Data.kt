package com.ysn.app_kotlin.data

import java.util.ArrayList

/**
 * 项目名称：Test0410
 * 创建人：fulin
 * 创建时间：2023/4/10 22:50
 * 类描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
class Data private constructor() {
    var appsList: List<App> = ArrayList()

    companion object {
        val instance = Data()
    }
}