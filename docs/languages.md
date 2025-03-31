# Languages

MoreTweaks currently supports 2 languages. To set your language, go to the `config.yml` file and set the `language` option to your desired language. The available languages are:
- English (US) - `en_us` - 100%
- Spanish (Mexico) - `es_mx` - ~90%

## Contributing to a language
Some languages are not fully translated. If you would like to contribute to a language or fix any mistakes, please follow these steps:
1. Fork the latest [dev branch](https://github.com/tarna/MoreTweaks/tree/dev/patch).
2. Edit the translation file in the `src/main/resources/lang` directory. The files are named after the language code (e.g. `en_us.yml` for English).
3. Translate the text to your desired language. Make sure to keep the formatting the same as the original file.
4. Commit your changes and create a pull request to the `dev` branch.
5. Once your pull request is merged and an update is released, you will be able to use your new translations in the plugin.

## Adding a new language
If you would like to contribute a new language, please follow these steps:
1. Fork the latest [dev branch](https://github.com/tarna/MoreTweaks/tree/dev/patch).
2. Head over to the [Language page on the Minecraft Wiki](https://minecraft.wiki/w/Language) and find the language code for your language.
3. Create a new file in the `src/main/resources/lang` directory with the name of your language code (e.g. `en_us.yml`).
4. Copy the contents of the `en_us.yml` file and translate the text to your desired language.
5. Please translate at least 50% for the language to be considered.
6. Make sure to keep the formatting the same as the original file.
7. Commit your changes and create a pull request to the `dev` branch.
8. Once your pull request is merged and an update is released, you will be able to use your new language in the plugin.