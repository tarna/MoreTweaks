# Durability Ping

## Description

Notify players when their tools are about to break.

## Options

| Name         | Description                                                                       | Type    | Default                                  |
|--------------|-----------------------------------------------------------------------------------|---------|------------------------------------------|
| enabled      | Whether this tweak is enabled.                                                    | boolean | false                                    |
| threshold    | The percentage of the tools durability needs to be for the player to be notified. | integer | 5                                        |
| message_type | The type of message to send to the player.                                        | string  | action_bar                               |
| message      | The message to send to the player.                                                | string  | <red><bold>Item durability is low!       |
| sound        | The sound to send to the player when this tweak is triggered.                     | sound   | minecraft:block.note_block.chime,1.0,1.0 |