package com.caffiendfrog.acc.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Created by sophia on 10/23/17.
 */
public class MyApplication implements EntryPoint {
    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        final Button button = new Button("Click me");
        final Label label = new Label("HELLLLLO");

//        button.addClickHandler(new ClickHandler() {
//            public void onClick(ClickEvent event) {
//                if (label.getText().equals("")) {
//                    MySampleApplicationService.App.getInstance().getMessage("Hello, World!", new MySampleApplication.MyAsyncCallback(label));
//                } else {
//                    label.setText("");
//                }
//            }
//        });

        // Assume that the host HTML has elements defined whose
        // IDs are "slot1", "slot2".  In a real app, you probably would not want
        // to hard-code IDs.  Instead, you could, for example, search for all
        // elements with a particular CSS class and replace them with widgets.
        //
        RootPanel.get("content").add(button);
        RootPanel.get("content").add(label);
    }
}
