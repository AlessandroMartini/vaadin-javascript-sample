package dev.ui;

import com.vaadin.cdi.CDIUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import dev.component.MyComponent;

@CDIUI("ui")
public class MyUI extends UI {

  @Override
  protected void init(VaadinRequest vaadinRequest) {

    final VerticalLayout layout = new VerticalLayout();

    final TextField name = new TextField();
    name.setCaption("Vaadin Textfield");

    Button button = new Button("Click Me");

    MyComponent mycomponent = new MyComponent();
    mycomponent.setValue("Server-side value");
    mycomponent.addValueChangeListener(() -> {
      name.setValue(mycomponent.getValue());
      Notification.show("Value: " + mycomponent.getValue());
    });

    button.addClickListener(e -> mycomponent.setValue(name.getValue()));

    layout.addComponent(mycomponent);
    layout.addComponents(name, button);

    setContent(layout);

  }
}
