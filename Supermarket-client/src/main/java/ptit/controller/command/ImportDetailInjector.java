package ptit.controller.command;

import org.springframework.stereotype.Component;
import ptit.model.ImportBill;
import ptit.model.ImportDetail;

import java.util.Stack;

@Component
public class ImportDetailInjector {
    private static final AddDetailCommand commandPrototype = new AddDetailCommand();
    private Stack<AddDetailCommand> commands;
    public ImportDetailInjector(){
        commands = new Stack<>();
    }
    public void addDetail(ImportDetail detail, ImportBill importBill){
        detail.setImportBill(importBill);
        AddDetailCommand command = commandPrototype.clone();
        command.setDetail(detail);
        command.execute();
        commands.add(command);
    }
    public void removeMostRecentDetail(){
        if (commands.empty()){
            return;
        }
        AddDetailCommand command = commands.pop();
        command.undo();
    }
}
