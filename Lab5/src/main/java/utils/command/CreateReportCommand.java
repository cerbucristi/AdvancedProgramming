package utils.command;

import exceptions.CommandExecutionException;
import exceptions.InvalidCatalogException;
import filemanagement.Catalog;
import freemarker.template.*;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class CreateReportCommand implements Command {

    private static final String TEMPLATE_NAME = "report.ftl";
    private Catalog catalog;

    public CreateReportCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void execute() throws CommandExecutionException {

        try {
            // Load the FreeMarker template from the resource file
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_30);
            cfg.setClassForTemplateLoading(getClass(), "/templates");
            Template template = cfg.getTemplate(TEMPLATE_NAME);

            if (catalog == null) {
                throw new InvalidCatalogException("Catalog was not instantiated!");
            }

            Map<String, Object> templateData = new HashMap<>();
            templateData.put("catalog", catalog);

            // Merge the template with the data model and write the result to a file
            try (Writer out = new FileWriter("report.html")) {
                template.process(templateData, out);
            }

            // Open the report in the default web browser
            Desktop.getDesktop().browse(new File("report.html").toURI());
        } catch (TemplateException | IOException | InvalidCatalogException e) {
            throw new CommandExecutionException(e);
        }
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }
}
