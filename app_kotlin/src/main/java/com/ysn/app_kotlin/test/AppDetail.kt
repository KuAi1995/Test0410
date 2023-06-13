package com.ysn.app_kotlin.test

import java.util.ArrayList

/**
 * 项目名称：SSLauncher
 * 创建人：fulin
 * 创建时间：2023/5/15 22:14
 * 类描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 */
class AppDetail private constructor(){
    var urls: List<String> = ArrayList()

    companion object {
        val instance = AppDetail()
    }
}