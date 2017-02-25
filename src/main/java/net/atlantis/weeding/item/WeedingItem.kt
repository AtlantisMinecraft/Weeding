package net.atlantis.weeding.item

import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import java.util.*

class WeedingItem {
    companion object Factory {
        private val LORE_TEXT = listOf(
                "為せば成る、為さねば成らぬ。何事も成らぬは人の為さぬなり",
                "険しい丘に登るためには、最初にゆっくり歩くことが必要である。",
                "目的と方針がなければ、努力と勇気は十分ではない。",
                "下を向いていたら、虹を見つけることは出来ないよ。",
                "あなたが転んでしまったことに関心はない。そこから立ち上がることに関心があるのだ。",
                "この世では誰もが苦しみを味わう。そして、その苦しみの場所から強くなれる者もいる。",
                "わたしは、決して失望などしない。どんな失敗も、新たな一歩となるからだ。",
                "才能よりも常に勇気をもっていたい。",
                "夢、これ以外に将来を作り出すものはない。",
                "シンプルであることを保て。",
                "無計画とは失敗のための計画だ。",
                "自信がなければ、常に勝たない方法を見つけてしまう。",
                "希望を抱かぬ者は、失望することもない。",
                "間違った知識には注意せよ。それは無知よりも危険である。",
                "おそらく人生で最も罪深いことは、正しいことだと知りつつそうしないことだ。",
                "この世の中で成功するには、力ずくで、死ぬまで剣を腕より離さないことだ。",
                "私が戦わなかった日など一日たりともありません。",
                "もし今日が人生最後の日だとしたら、今やろうとしていることは 本当に自分のやりたいことだろうか？",
                "夢なき者に成功なし",
                "失敗の責任は主君に、成功の功績は家臣に",
                "私がしているのは決して大きなことではないが、必要なことなのだ"
        )

        val TOTEM_NAME = ChatColor.RESET.toString() + ChatColor.YELLOW.toString() + "Totem of Weeding"

        fun totem(): ItemStack {
            val itemStack = ItemStack(Material.TOTEM)
            val itemMeta = itemStack.itemMeta
            itemMeta.displayName = TOTEM_NAME
            itemMeta.lore = listOf(ChatColor.RESET.toString() + "右クリックで除草することができます", "", loreText())
            itemStack.itemMeta = itemMeta
            return itemStack
        }

        private fun loreText(): String {
            val num = Random().nextInt(LORE_TEXT.size)
            return LORE_TEXT[num]
        }
    }
}