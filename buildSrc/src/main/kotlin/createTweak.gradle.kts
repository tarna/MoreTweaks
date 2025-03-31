import java.io.BufferedReader
import java.io.InputStreamReader

tasks.register("createTweak") {
    group = "moretweaks"
    doLast {
        val tweakName = if (project.hasProperty("tweakName")) {
            project.property("tweakName") as String
        } else {
            BufferedReader(InputStreamReader(System.`in`)).readLine()
        }

        val tweakDescription = if (project.hasProperty("tweakDescription")) {
            project.property("tweakDescription") as String
        } else {
            BufferedReader(InputStreamReader(System.`in`)).readLine()
        }

        val id = tweakName.replace(" ", "_").lowercase()

        val tweakFolderName = tweakName.replace(" ", "")
        val tweaksFolder = project.file("src/main/kotlin/dev/tarna/moretweaks/tweaks")
        val tweakFile = tweaksFolder.resolve("$tweakFolderName.kt")

        val configFolder = project.file("src/main/kotlin/dev/tarna/moretweaks/config/tweaks")
        val tweakConfigFile = configFolder.resolve("${tweakFolderName}Config.kt")

        val resourcesFolder = project.file("src/main/resources")
        val langFolder = resourcesFolder.resolve("lang")

        val docFileName = tweakName.replace(" ", "-").lowercase()
        val docsFolder = project.file("docs")
        val docsFile = docsFolder.resolve("tweaks/${docFileName}.md")
        val summaryFile = docsFolder.resolve("SUMMARY.md")

        tweakFile.writeText(
            """
            package dev.tarna.moretweaks.tweaks

            import dev.tarna.moretweaks.api.tweaks.Tweak

            class $tweakFolderName : Tweak {
                override val id = "$id"

                override fun reload() {
                    // Reload your tweak here
                }
            }
            """.trimIndent()
        )

        tweakConfigFile.writeText(
            """
            package dev.tarna.moretweaks.config.tweaks

            import dev.tarna.moretweaks.api.config.options.impl.BooleanOption

            object ${tweakFolderName}Config {
                var enabled by BooleanOption("tweaks.$id.enabled", false)
            }
            """.trimIndent()
        )

        docsFile.writeText(
            """
                # $tweakName
                
                ## Description
                
                $tweakDescription

                ## Configuration

                | Name    | Description                                    | Type      | Default |
                |---------|------------------------------------------------|-----------|---------|
                | enabled | Whether this tweak is enabled.                 | boolean   | false   |
            """.trimIndent()
        )

        val summaryLines = summaryFile.readLines()
        val newSummaryLines = summaryLines.toMutableList()
        val newSummaryLine = "* [$tweakName](tweaks/$docFileName.md)"
        val index = summaryLines.indexOfFirst { it > newSummaryLine }
        if (index == -1) {
            newSummaryLines.add(newSummaryLine)
        } else {
            newSummaryLines.add(index, newSummaryLine)
        }
        summaryFile.writeText(newSummaryLines.joinToString("\n"))

        val langFiles = langFolder.listFiles() ?: emptyArray()
        for (langFile in langFiles) {
            val langLines = langFile.readLines()
            val newLangLines = langLines.toMutableList()

            // Find the tweak section
            val tweakStartIndex = newLangLines.indexOfFirst { it.trim() == "tweak:" }
            if (tweakStartIndex != -1) {
                val tweakEndIndex = newLangLines.indexOfFirst { it.trim().startsWith("recipe:") }
                val tweakSection = newLangLines.subList(tweakStartIndex + 1, if (tweakEndIndex == -1) newLangLines.size else tweakEndIndex).toMutableList()

                // Insert the new entry in alphabetical order
                val newLangEntry = """
                    $id:
                      name: "$tweakName"
                      description: "$tweakDescription"
                """.trimIndent()
                val insertIndex = tweakSection.indexOfFirst { it.trim() > newLangEntry.trim() }
                val indentedNewLangEntry = newLangEntry.lines().joinToString("\n") { "  $it" }
                if (insertIndex == -1) {
                    tweakSection.add(indentedNewLangEntry)
                } else {
                    tweakSection.add(insertIndex, indentedNewLangEntry)
                }

                // Update the lang file
                newLangLines.clear()
                newLangLines.addAll(langLines.subList(0, tweakStartIndex + 1))
                newLangLines.addAll(tweakSection)
                if (tweakEndIndex != -1) {
                    newLangLines.addAll(langLines.subList(tweakEndIndex, langLines.size))
                }
                langFile.writeText(newLangLines.joinToString("\n"))
            }
        }

        val files = listOf(tweakFile, tweakConfigFile, docsFile, summaryFile).map { it.absolutePath }

        project.exec {
            commandLine("git", "add", *files.toTypedArray())
        }
    }
}