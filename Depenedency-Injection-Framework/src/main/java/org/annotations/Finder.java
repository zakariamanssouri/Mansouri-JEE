package org.annotations;

import org.burningwave.core.assembler.ComponentContainer;
import org.burningwave.core.assembler.ComponentSupplier;
import org.burningwave.core.classes.ClassHunter;
import org.burningwave.core.classes.ClassHunter.SearchResult;
import org.burningwave.core.classes.SearchConfig;

import java.util.Collection;

public class Finder {
    private String packagename;

    public Finder(String packagename) {
        this.packagename = packagename;
    }

    public Collection<Class<?>> scanClasses() {
        ComponentSupplier componentSupplier = ComponentContainer.getInstance();
        ClassHunter classHunter = componentSupplier.getClassHunter();

        try (SearchResult result = classHunter.findBy(
                //Highly optimized scanning by filtering resources before loading from ClassLoader
                SearchConfig.forResources(
                        this.packagename
                )
        )) {

            return result.getClasses();
        }
    }

}
