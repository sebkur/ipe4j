# Recreating the generated XML binding classes

    xjc -dtd -p de.topobyte.ipe.jaxb.model -d src/main/java ipe.dtd

To avoid noise and get clean diffs, use the Eclipse formatter after
generating the source files.
