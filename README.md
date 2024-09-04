# REMS-Carpet-Extra

# carpet的命令设置
原版carpet指令请参考[wiki](https://github.com/gnembon/fabric-carpet/wiki/Current-Available-Settings)或[汉化版本](https://github.com/SFG-Minecraft-mods-Chinese-Translation/Translation-doc/blob/master/Fabric-Carpet/Commands.md)

# 免责声明
### 这个模组的初衷是为了整合我所用到的一些功能和看到觉得想要的一些功能的合集。

# 新增功能


## 活塞头加载(pistonBlockChunkLoader)
开启后，当该活塞/黏性活塞产生活塞头的推出/拉回事件时，在创建推出/拉回事件的那一游戏刻为**活塞头方块所在区块**添加类型为"piston_block"，加载等级为30的加载票，持续时间为30gt（1.5s）。
* 默认值: `OFF`
* 可选参数: `ON`, `OFF`
* 开启方法: `/carpet PearlTickets ON`
* 分类: `REMS` , `Survival` 
> 如果不想使用地狱门加载链的话，此规则可作为替代方案。

## 更好的TNT合并(mergeTNTPro)
合并大量TNT以减小实体及爆炸带来的卡顿
* 默认值: `false`
* 可选参数: `true`, `false`
* 开启方法: `/carpet mergeTNTPro true`
* 分类: `REMS`, `Feature`, `Survival`

**移植自：**
ten-miles-away 的[HIT-Carpet](https://github.com/HIT-Craft/HIT-Carpet/tree/1.14.4)

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

## POI传送门(teleportToPoiWithoutPortals)
重新添加传送至没有传送门方块的传送门POI的规则
* 默认值: `false`
* 可选参数: `true`, `false`
* 开启方法: `/carpet teleportToPoiWithoutPortals true`
* 分类: `REMS` , `Experimental`
> 和锂有冲突

**移植自：**
Copetan 的[lunaar-carpet-addons](https://github.com/Lunaar-SMP/lunaar-carpet-addons)

## 保持实体更新(keepWorldTickUpdate)
在服务器当前维度没有玩家的300tick后，Minecraft会停止实体相关的更新，这条规则会绕过这个限制。
* 默认值: `false`
* 可选参数: `true`, `false`
* 开启方法: `/carpet keepWorldTickUpdate true`
* 分类: `REMS` , `Feature`

**移植自：**
1024-byteeeee 的[Carpet-AMS-Addition](https://github.com/Minecraft-AMS/Carpet-AMS-Addition)

# Works Cited
- gnembon [fabric-carpet](https://github.com/LucunJi/fabric-carpet)
- Copetan [lunaar-carpet-addons](https://github.com/Lunaar-SMP/lunaar-carpet-addons)
- 1024-byteeeee [Carpet-AMS-Addition](https://github.com/Minecraft-AMS/Carpet-AMS-Addition)
