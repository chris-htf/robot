package net.mamoe.mirai.simpleloader

import kotlinx.coroutines.*
import net.mamoe.mirai.Bot
import net.mamoe.mirai.alsoLogin
import net.mamoe.mirai.join
import net.mamoe.mirai.message.data.At
import net.mamoe.mirai.contact.Member
import net.mamoe.mirai.event.subscribeMessages

suspend fun main() {
    val qqId = 3242342415L//Bot的QQ号，需为Long类型，在结尾处添加大写L
    val password = "20200910robot"//Bot的密码
    val miraiBot = Bot(qqId, password).alsoLogin()//新建Bot并登录
    miraiBot.subscribeMessages {
        "你好" reply "你好!"
        case("at me") {
            reply(At(sender as Member) + " 给爷爬 ")
        }
        case("大圣此去何处") {
            reply("踏碎凌霄")
        }
        case("hello") {
            reply("world")
        }
        case("若一去不回") {
            reply("便一去不回")
        }

        (contains("舔") or contains("刘老板")) {
            reply("刘老板太强了")
        }
    }
    miraiBot.join() // 等待 Bot 离线, 避免主线程退出
}