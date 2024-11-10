# REMS-Carpet-Extra

## 支持版本
|  游戏版本  | 开发状态 |
|:------:|:----:|
| 1.20.5 |  ✔   |
| 1.20.1 |  ✔   |
|  1.20  |  ✔   |
| 1.19.4 |  ✔   |



# 免责声明
### 这个模组的初衷是为了整合我所用到的一些功能和看到觉得想要的一些功能的合集。

# 新增功能

## 活塞头加载(pistonBlockChunkLoader)
开启后，当该活塞/黏性活塞头产生活塞头的推出/拉回事件时，在创建推出/拉回事件的那一游戏刻为**活塞头方块所在区块**添加类型为"piston_block"的加载票，持续时间为60gt（3s）。
## 活塞上面方块类型
| 方块类型 |   加载大小   |
|:----:|:--------:|
| 钻石矿  | 弱加载1x1区块 |
| 绿宝石矿 | 强加载3X3区块 |
|  金矿  | 强加载1X1区块 |
* 默认值: `OFF`
* 可选参数: `ON`, `OFF`
* 开启方法: `/carpet PearlTickets ON`
* 分类: `REMS` , `Survival` 
> 如果不想使用地狱门加载链的话，此规则可作为替代方案。

## 更好的TNT合并(mergeTNTPro)
合并大量TNT以减小实体及爆炸带来的卡顿，能显著降低mspt

可能开启后TNT给予的动量会有一些小小的变化，只需要改下落点就好了（介意可以不开）
* 默认值: `false`
* 可选参数: `true`, `false`
* 开启方法: `/carpet mergeTNTPro true`
* 分类: `REMS`, `Feature`, `Survival`

## 末影珍珠加载(PearlTickets)
这个mod允许末影珍珠实体选择性地加载即将通过的区块，这样珍珠炮打出的珍珠就不会因为进入未加载区块而丢失。在1.14+中可以替代地狱门加载链使用。

该mod相比于@gnembon/carpet-extra mod的enderPearlChunkLoading功能有显著的性能提升
* 默认值: `OFF`
* 可选参数: `ON`, `OFF`
* 开启方法: `/carpet pistonBlockChunkLoader ON`
* 分类: `REMS` , `Survival`
> 如果不想使用地狱门加载链的话，此规则可作为替代方案。
 
**移植自：**
SunnySlopes 的[PearlTickets](https://github.com/SunnySlopes/PearlTickets)

## 计划刻催熟仙人掌(scheduledRandomTickCactus)
当仙人掌方块收到计划刻时仍会给予生长随机刻
* 默认值: `false`
* 可选参数: `true`, `false`
* 开启方法: `/carpet scheduledRandomTickCactus true`
* 分类: `REMS`, `Feature`, `Survival`

**移植自：**[OhMyVanillaMinecraft](https://github.com/hit-mc/OhMyVanillaMinecraft)

## 保持实体更新(keepWorldTickUpdate)
在服务器当前维度没有玩家的300tick后，Minecraft会停止实体相关的更新，这条规则会绕过这个限制。
* 默认值: `false`
* 可选参数: `true`, `false`
* 开启方法: `/carpet keepWorldTickUpdate true`
* 分类: `REMS` , `Feature`

## 禁止蝙蝠生成(DisableBatCanSpawn)
阻止蝙蝠自然生成
* 默认值: `false`
* 可选参数: `true`, `false`
* 开启方法: `/carpet disableBatCanSpawn true`
* 分类: `REMS` , `Feature`

## 仙人掌扳手音效(CactusWrenchSound)
使用仙人掌扳手时播放 'BLOCK_DISPENSER_LAUNCH' 音效
* 默认值: `false`
* 可选参数: `true`, `false`
* 开启方法: `/carpet CactusWrenchSound true`
* 分类: `REMS` , `Survival` ,`Creative`

## 禁止传送门更新(DisablePortalUpdate)
下界传送门方块收到方块更新后不会做出反应
* 默认值: `false`
* 可选参数: `true`, `false`
* 开启方法: `/carpet disablePortalUpdate true`
* 分类: `REMS` , `Survival` ,`Experimental`


# Works Cited
- gnembon [fabric-carpet](https://github.com/gnembon/fabric-carpet)
- Copetan [lunaar-carpet-addons](https://github.com/Lunaar-SMP/lunaar-carpet-addons)
- 1024-byteeeee [Carpet-AMS-Addition](https://github.com/Minecraft-AMS/Carpet-AMS-Addition)
