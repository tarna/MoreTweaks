# Pet Memorial Name Tag

## Description

Drops a memorial item when a pet dies.

## Options

| Name               | Description                                                                             | Type    | Default                               |
|--------------------|-----------------------------------------------------------------------------------------|---------|---------------------------------------|
| enabled            | Whether this tweak is enabled.                                                          | boolean | false                                 |
| drop               | The item to drop as the memorial item. Can be changed if needed.                        | item    | NAME\_TAG                             |
| chance             | The chance for the memorial item to drop.                                               | integer | 100                                   |
| format             | The format of the name of the memorial item.                                            | string  | <red><bold>In Memory of <white><name> |
| show_death_message | Whether to show the pet's death message when the memorial item is right clicked.        | boolean | true                                  |
| should_burn        | Whether the memorial item should burn. Useful to prevent the item to be burned by lava. | boolean | false                                 |