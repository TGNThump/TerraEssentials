## TerraEssentials
[![Master](https://img.shields.io/badge/branch-master-orange.svg)](https://github.com/TerraGamingNetwork/TerraEssentials/tree/master) [![Build Status](https://img.shields.io/travis/TerraGamingNetwork/TerraEssentials/master.svg)](https://travis-ci.org/TerraGamingNetwork/TerraEssentials/branches) [![Code Quality](https://img.shields.io/codacy/cf4615d013ec4d37872ecbfcc58b5396/master.svg)](https://www.codacy.com/app/groovyben008/TerraEssentials) [![GitHub tags](https://img.shields.io/github/tag/TerraGamingNetwork/TerraEssentials.svg)](https://github.com/TerraGamingNetwork/TerraEssentials/tags)
<br />
[![Develop](https://img.shields.io/badge/branch-develop-orange.svg)](https://github.com/TerraGamingNetwork/TerraEssentials/tree/develop) [![Build Status](https://img.shields.io/travis/TerraGamingNetwork/TerraEssentials/develop.svg)](https://travis-ci.org/TerraGamingNetwork/TerraEssentials/branches) [![Code Quality](https://img.shields.io/codacy/cf4615d013ec4d37872ecbfcc58b5396/develop.svg)](https://www.codacy.com/app/groovyben008/TerraEssentials)

TerraEssentials is a TerraCore Module that adds the essential commands needed to run a Sponge server.

## Commands

| Command    | Description                                | Parameters                     | Permission                                             |
|------------|--------------------------------------------|--------------------------------|--------------------------------------------------------|
| /gamemode<br />/gm  | Set the target players gamemode.           | &lt;gamemode&gt; [target]...         | tc.core.gamemode,<br /> tc.core.gamemode.others              |
| /fly       | Toggles the target players ability to fly. | [target]...                    | tc.core.fly,<br /> tc.core.fly.others                        |
| /speed<br />/s     | Changes the target players speed.          | &lt;speed&gt; [target]...            | tc.core.speed,<br /> tc.core.speed.others                    |
| /clear<br />/ci<br />/clearinventory     | Clear the target players inventory.        | [target]...                    | tc.core.clear,<br /> tc.core.clear.others                    |
| /enchant<br />/ench   | Enchant the item in your hand.             | &lt;enchantment&gt; &lt;level&gt; [-force] | tc.core.enchant,<br /> tc.core.enchant.unsafe                |
| /heal      | Heal the target players.                   | [target]...                    | tc.core.heal,<br /> tc.core.heal.others                      |
| /feed      | Feed the target players.                   | [target]...                    | tc.core.feed,<br /> tc.core.feed.others                      |
| /invsee    | View the target players inventory.         | &lt;target&gt;                       | tc.core.invsee                                         |
| /thru<br />/through      | Jump through the wall in front of you.     |                                | tc.core.thru                                           |
| /jump      | Jump to where you are looking.             |                                | tc.core.jump                                           |
| /vanish<br />/v    | Toggle the target players visability.      | [target]...                    | tc.core.vanish,<br /> tc.core.vanish.others                  |
| /weather   | Set the weather.                           | &lt;weather&gt; [duration]           | tc.core.weather                                        |
| /spawn     | Teleport to spawn.                         | [-force]                       | tc.core.spawn,<br /> tc.core.spawn.unsafe                    |
| /spawn set<br />/setspawn | Set the spawn point.                       |                                | tc.core.spawn.set                                      |
| /time      | Get or set the time.                       | [time]                         | tc.core.time                                           |
| /home      | Teleport to the targets home.              | [target] [-force]              | tc.core.home,<br /> tc.core.home.others,<br /> tc.core.home.unsafe |
| /home set<br />/sethome  | Set your home                              |                                | tc.core.home.set                                       |
| /teleport<br />/tp  | Teleport to a world.                       | &lt;world&gt;                        | tc.core.tp.world                                       |
| /teleport<br />/tp  | Teleport to a player.                      | &lt;target&gt;                       | tc.core.tp.player                                      |
| /teleport<br />/tp  | Teleport a player to a player.             | &lt;target&gt; &lt;destination&gt;         | tc.core.tp.player                                      |

## Building

To build the project, run `mvn clean install` from the root directory. The built jar is located in `target/`.

## Contributing

Thank you for considering contributing to TerraEssentials. If you would like to help, but don't know what to do, take a look at the [Issues](https://github.com/TerraGamingNetwork/TerraEssentials/issues) or join us on the Terra Gaming Network [Slack Team](http://slack.terragaming.co.uk).

## License
All TerraCore code is released under the [CC BY-NC-SA 4.0](http://creativecommons.org/licenses/by-nc-sa/4.0// "Attribution-NonCommercial-ShareAlike 4.0 International").
