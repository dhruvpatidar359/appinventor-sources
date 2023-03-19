package com.google.appinventor.client.wizards;



import com.google.appinventor.client.editor.youngandroid.properties.YoungAndroidSizingChoicePropertyEditor;
import com.google.appinventor.client.editor.youngandroid.properties.YoungAndroidThemeChoicePropertyEditor;
import com.google.appinventor.client.widgets.DropDownButton;
import com.google.appinventor.client.widgets.LabeledTextBox;



import com.google.common.collect.Lists;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;



import java.util.List;

public class AppPropertiesWizard extends Wizard{


    private YoungAndroidThemeChoicePropertyEditor projectTheme;
    private YoungAndroidSizingChoicePropertyEditor projectSizing;
    private CheckBox checkBoxShowListAsJson;
    private Label labelTheme;
    private Label labelSizing;
    private Label labelShowListAsJson;
    private LabeledTextBox tutorialUrl;
    private LabeledTextBox versionCode;
    private LabeledTextBox versionName;
    private LabeledTextBox icon;

    private DropDownButton dropDownButton;





    public AppPropertiesWizard(String title, boolean modal, boolean adaptiveSizing) {
        super("Project Settings", true, false);


        setStylePrimaryName("ode-DialogBox");




       projectTheme = new YoungAndroidThemeChoicePropertyEditor();
       projectSizing = new YoungAndroidSizingChoicePropertyEditor();
       checkBoxShowListAsJson = new CheckBox();
       labelShowListAsJson = new Label("ShowListsAsJson");
       tutorialUrl = new LabeledTextBox("TutorailURL");
       versionCode = new LabeledTextBox("VersionCode");
       versionName = new LabeledTextBox("VersionName");
       labelTheme = new Label("Theme");
       labelSizing = new Label("Sizing");
       icon = new LabeledTextBox("Icon");


        List<DropDownButton.DropDownItem> items = Lists.newArrayList();
        items.add(new DropDownButton.DropDownItem("dropdown", "Classic", new Command() {
            @Override
            public void execute() {
                Window.alert("i am working and no error is coming");



                dropDownButton.setCaption("Classic");
            }
        }));

        items.add(new DropDownButton.DropDownItem("dropdown", "AppTheme.Light", new Command() {
            @Override
            public void execute() {
                Window.alert("i am working and no error is coming part 2");
                dropDownButton.setCaption("AppTheme.Light");
            }
        }));

        dropDownButton = new DropDownButton("Choice Property Editor", "Class", items, false);

        dropDownButton.setStylePrimaryName("ode-ChoicePropertyEditor");


        VerticalPanel page = new VerticalPanel();


        HorizontalPanel subPage = new HorizontalPanel();
        subPage.add(labelTheme);
        subPage.add(projectTheme);
        subPage.add(labelSizing);
        subPage.add(projectSizing);


        HorizontalPanel subPage2 = new HorizontalPanel();
        subPage2.add(icon);
        subPage2.add(tutorialUrl);




        HorizontalPanel subPage3 = new HorizontalPanel();
        subPage3.add(versionCode);
        subPage3.add(versionName);


        HorizontalPanel subPage4 = new HorizontalPanel();
        subPage4.add(labelShowListAsJson);
        subPage4.add(checkBoxShowListAsJson);
        subPage4.add(dropDownButton);








        page.add(subPage);
        page.add(subPage2);
        page.add(subPage3);
        page.add(subPage4);
        addPage(page);




        initFinishCommand(new Command() {
            @Override
            public void execute() {




                Window.alert(dropDownButton.getText());
                center();


            }
        });


}


    @Override
    public void show() {
        super.show();




        int width = 600;
        int height = 400;
        this.center();


        setPixelSize(width, height);
        super.setPagePanelHeight(200);






        DeferredCommand.addCommand(new Command() {
            public void execute() {


            }
        });
    }
}


