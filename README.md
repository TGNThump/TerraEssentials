# TerraEssentials
[![Master](https://img.shields.io/badge/branch-master-orange.svg)](https://github.com/TerraGamingNetwork/TerraEssentials/tree/master) [![Build Status](https://img.shields.io/travis/TerraGamingNetwork/TerraEssentials/master.svg)](https://travis-ci.org/TerraGamingNetwork/TerraEssentials/branches) [![Code Quality](https://img.shields.io/codacy/cf4615d013ec4d37872ecbfcc58b5396/master.svg)](https://www.codacy.com/app/groovyben008/TerraEssentials) [![GitHub tags](https://img.shields.io/github/tag/TerraGamingNetwork/TerraEssentials.svg)](https://github.com/TerraGamingNetwork/TerraEssentials/tags)<br />
[![Develop](https://img.shields.io/badge/branch-develop-orange.svg)](https://github.com/TerraGamingNetwork/TerraEssentials/tree/develop) [![Build Status](https://img.shields.io/travis/TerraGamingNetwork/TerraEssentials/develop.svg)](https://travis-ci.org/TerraGamingNetwork/TerraEssentials/branches) [![Code Quality](https://img.shields.io/codacy/cf4615d013ec4d37872ecbfcc58b5396/develop.svg)](https://www.codacy.com/app/groovyben008/TerraEssentials)

TerraEssentials is a [TerraCore](https://github.com/TerraGamingNetwork/TerraCore) Module that adds the essential commands needed to run a Sponge server.

## Commands

| Command | Description | Parameters | Permission |
|---|---|---|---|
|  |  |  |
| **`/teleport`** <br/> `/tp` | Teleport to a world. | &lt;world&gt; | tc.essentials.tp.world |
| **`/teleport`** <br/> `/tp` | Teleport to a player. | &lt;target&gt; | tc.essentials.tp.player |
| **`/teleport`** <br/> `/tp` | Teleport to a player to another player. | &lt;target&gt; &lt;destination&gt; | tc.essentials.tp.player.others |
| **`/bring`** <br/> `/tphere` | Teleport a player to you. | &lt;target&gt;... | tc.essentials.tp.player.others |
| **`/spawn`** | Teleport to spawn. | | tc.essentials.tp.spawn |
| **`/spawn set`** <br /> `/setspawn` | Set the spawn point. | | tc.essentials.tp.spawn.set |
| **`/home`** | Teleport to your home. | | tc.essentials.tp.home |
| **`/home`** | Teleport you to the targets home. | &lt;target&gt; | tc.essentials.tp.home.others |
| **`/home set`** <br /> `/sethome` | Set your home. | | tc.essentials.tp.home.set |
| **`/jump`** | Jump to where you are looking. | | tc.essentials.tp.jump |
| **`/thru`** <br /> `/through` | Jump through the wall in front of you. | | tc.essentials.tp.thru |
|  |  |  |
| **`/time`** | Get the current time. | | tc.essentials.world.time |
| **`/time`** | Sets the current time. | &lt;time&gt; | tc.essentials.world.time.set |
| **`/weather`** | Sets the current weather. | &lt;weather&gt; [duration] | tc.essentials.world.weather.set |
|  |  |  |
| **`/heal`** | Heals the target players. | [target]... | tc.essentials.cheats.heal,<br/>tc.essentials.cheats.heal.others |
| **`/feed`** | Feed the target players. | [target]... | tc.essentials.cheats.feed,<br/>tc.essentials.cheats.feed.others |
| **`/gamemode`** <br /> `/gm` | Set the target players gamemode. | &lt;gamemode&gt; [target]... | tc.essentials.cheats.gamemode,<br />tc.essentials.cheats.gamemode.others |
| **`/gmc`** | Set the target players to creative mode. | [target]... | tc.essentials.cheats.gamemode,<br />tc.essentials.cheats.gamemode.others |
| **`/gms`** | Set the target players to survival mode. | [target]... | tc.essentials.cheats.gamemode,<br />tc.essentials.cheats.gamemode.others |
| **`/gma`** | Set the target players to adventure mode. | [target]... | tc.essentials.cheats.gamemode,<br />tc.essentials.cheats.gamemode.others |
| **`/fly`** | Toggles the target players ability to fly. | [target]... | tc.essentials.cheats.fly,<br/>tc.essentials.cheats.fly.others |
| **`/speed`** <br /> `/s` | Sets the target players speed. | &lt;speed&gt; [target]... | tc.essentials.cheats.speed,<br/>tc.essentials.cheats.speed.others |
| **`/enchant`** <br /> `/ench` | Enchant the item you are holding. | &lt;enchantment&gt; &lt;level&gt; [-force] | tc.essentials.cheats.enchant,<br/>tc.essentials.cheats.enchant.unsafe |
| **`/clear`** <br /> `/clearinventory` <br /> `/ci` | Clears the target players inventory. | [target]... | tc.essentials.cheats.clear,<br/>tc.essentials.cheats.clear.others |
|  |  |  |
| **`/invsee`** | View the target players inventory. | &lt;target&gt; | tc.essentials.admin.invsee |
| **`/vanish`** <br /> `/v` | Toggles the target players visability. | [target]... | tc.essentials.admin.vanish,<br />tc.essentials.admin.vanish.others |

## Building

To build the project, run `mvn clean install` from the root directory. The built jar is located in `target/`.

## Contributing

Thank you for considering contributing to TerraEssentials. If you would like to help, but don't know what to do, take a look at the [Issues](https://github.com/TerraGamingNetwork/TerraEssentials/issues) or join us on the Terra Gaming Network [Slack Team](http://slack.terragaming.co.uk).

## License
All TerraCore code is released under the [CC BY-NC-SA 4.0](http://creativecommons.org/licenses/by-nc-sa/4.0// "Attribution-NonCommercial-ShareAlike 4.0 International").
