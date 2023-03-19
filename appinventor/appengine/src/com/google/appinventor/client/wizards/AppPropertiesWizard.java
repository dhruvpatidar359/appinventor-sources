package com.google.appinventor.client.wizards;



import static com.google.appinventor.client.Ode.MESSAGES;


import com.google.appinventor.client.widgets.DropDownButton;
import com.google.appinventor.client.widgets.LabeledTextBox;


import com.google.appinventor.client.widgets.properties.ColorChoicePropertyEditor;
import com.google.appinventor.shared.rpc.ServerLayout;
import com.google.common.collect.Lists;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;



import java.util.List;

public class AppPropertiesWizard extends Wizard{



    private CheckBox checkBoxShowListAsJson;
    private Label labelTheme;
    private Label labelSizing;
    private Label labelShowListAsJson;
    private Label labelPrimaryColor;

    private Label labelPrimaryColorDark;
    private LabeledTextBox tutorialUrl;
    private LabeledTextBox versionCode;
    private LabeledTextBox versionName;
    private Label icon;
    private Label labelAccentColor;
    private  Label labelDefaultFileScope;

    private DropDownButton dropDownTheme;
    private DropDownButton dropDownSizing;

    private DropDownButton dropDownPrimary;
    private DropDownButton dropDownPrimaryDark;
    private DropDownButton dropDownAccentColor;
    private DropDownButton dropDownDefaultFileScope;



    public AppPropertiesWizard(String title, boolean modal, boolean adaptiveSizing) {
        super("Project Settings", true, false);


        setStylePrimaryName("ode-DialogBox");





       checkBoxShowListAsJson = new CheckBox();
       labelShowListAsJson = new Label(MESSAGES.listAsJson());
       tutorialUrl = new LabeledTextBox(MESSAGES.tutorialURL());
       versionCode = new LabeledTextBox(MESSAGES.versionCode());
       versionName = new LabeledTextBox(MESSAGES.versionName());
       labelTheme = new Label(MESSAGES.theme());
       labelSizing = new Label(MESSAGES.sizing());
       icon = new Label(MESSAGES.icon());
       labelPrimaryColor = new Label(MESSAGES.primaryColor());
       labelPrimaryColorDark = new Label(MESSAGES.primaryColorDark());
       labelAccentColor = new Label(MESSAGES.accentColor());
       labelDefaultFileScope = new Label(MESSAGES.defaultFileScope());


        // DropDown for the Project Theme Property
        List<DropDownButton.DropDownItem> items1 = Lists.newArrayList();
        CustomChoice[] choices1 = new CustomChoice[4];
        choices1[0] = new CustomChoice(MESSAGES.classicTheme(),"Classic");
        choices1[1] = new CustomChoice(MESSAGES.defaultTheme(),"AppTheme.Light.DarkActionBar");
        choices1[2] = new CustomChoice(MESSAGES.blackTitleTheme(),"AppTheme.Light");
        choices1[3] = new CustomChoice(MESSAGES.darkTheme(),"AppTheme");

        for(CustomChoice choice : choices1){
            items1.add(new DropDownButton.DropDownItem("dropdown", choice.caption, () -> {
                Window.alert("i am working and no error is coming");
                dropDownTheme.setCaption(choice.caption);
            }));

        }

        dropDownTheme = new DropDownButton("Choice Property Editor", MESSAGES.classicTheme(), items1, false);
        dropDownTheme.setStylePrimaryName("ode-ChoicePropertyEditor");

        // DropDown for the Project Sizing Property

        CustomChoice[] choices2 = new CustomChoice[2];
        choices2[0] = new CustomChoice(MESSAGES.fixedSizing(),"Fixed");
        choices2[1] = new CustomChoice(MESSAGES.responsiveSizing(),"Responsive");


        List<DropDownButton.DropDownItem> items2 = Lists.newArrayList();

        for(CustomChoice choice : choices2){
            items2.add(new DropDownButton.DropDownItem("dropdown", choice.caption, () -> {
                Window.alert("i am working and no error is coming");
                dropDownSizing.setCaption(choice.caption);
            }));

        }

        dropDownSizing = new DropDownButton("Choice Property Editor", MESSAGES.fixedSizing(), items2, false);
        dropDownSizing.setStylePrimaryName("ode-ChoicePropertyEditor");


        // DropDown for DefaultFileScope
        CustomChoice[] choices3 = new CustomChoice[2];
        choices3[0] = new CustomChoice(MESSAGES.fileScopeApp(), "App");
        choices3[1] = new CustomChoice(MESSAGES.fileScopeAsset(), "Asset");
        choices3[2] = new CustomChoice(MESSAGES.fileScopeCache(), "Cache");
        choices3[3] = new CustomChoice(MESSAGES.fileScopeLegacy(), "Legacy");
        choices3[4] = new CustomChoice(MESSAGES.fileScopePrivate(), "Private");
        choices3[5] = new CustomChoice(MESSAGES.fileScopeShared(), "Shared");

        List<DropDownButton.DropDownItem> items6 = Lists.newArrayList();

        for(CustomChoice choice : choices3){
            items6.add(new DropDownButton.DropDownItem("dropdown", choice.caption, () -> {
                Window.alert("i am working and no error is coming");
                dropDownDefaultFileScope.setCaption(choice.caption);
            }));

        }

        dropDownDefaultFileScope = new DropDownButton("Choice Property Editor", MESSAGES.fixedSizing(), items6, false);
        dropDownDefaultFileScope.setStylePrimaryName("ode-ChoicePropertyEditor");

        // Creating color DropDown


         CustomColor[] YA_COLORS = {
                new CustomColor(MESSAGES.noneColor(), ColorChoicePropertyEditor.Color.ALPHA_TRANSPARENT, "FFFFFF"),
                new CustomColor(MESSAGES.blackColor(), ColorChoicePropertyEditor.Color.ALPHA_OPAQUE, "000000"),
                new CustomColor(MESSAGES.blueColor(), ColorChoicePropertyEditor.Color.ALPHA_OPAQUE, "0000FF"),
                new CustomColor(MESSAGES.cyanColor(), ColorChoicePropertyEditor.Color.ALPHA_OPAQUE, "00FFFF"),
                new CustomColor(MESSAGES.defaultColor(), ColorChoicePropertyEditor.Color.ALPHA_TRANSPARENT, "000000"),
                new CustomColor(MESSAGES.darkGrayColor(), ColorChoicePropertyEditor.Color.ALPHA_OPAQUE, "444444"),
                new CustomColor(MESSAGES.grayColor(), ColorChoicePropertyEditor.Color.ALPHA_OPAQUE, "888888"),
                new CustomColor(MESSAGES.greenColor(), ColorChoicePropertyEditor.Color.ALPHA_OPAQUE, "00FF00"),
                new CustomColor(MESSAGES.lightGrayColor(), ColorChoicePropertyEditor.Color.ALPHA_OPAQUE, "CCCCCC"),
                new CustomColor(MESSAGES.magentaColor(), ColorChoicePropertyEditor.Color.ALPHA_OPAQUE, "FF00FF"),
                new CustomColor(MESSAGES.orangeColor(), ColorChoicePropertyEditor.Color.ALPHA_OPAQUE, "FFC800"),
                new CustomColor(MESSAGES.pinkColor(), ColorChoicePropertyEditor.Color.ALPHA_OPAQUE, "FFAFAF"),
                new CustomColor(MESSAGES.redColor(), ColorChoicePropertyEditor.Color.ALPHA_OPAQUE, "FF0000"),
                new CustomColor(MESSAGES.whiteColor(), ColorChoicePropertyEditor.Color.ALPHA_OPAQUE, "FFFFFF"),
                new CustomColor(MESSAGES.yellowColor(), ColorChoicePropertyEditor.Color.ALPHA_OPAQUE, "FFFF00")
        };

        List<DropDownButton.DropDownItem> items3 = Lists.newArrayList();

        for( CustomColor i : YA_COLORS){
            String html = "<span style=\"background:#" + i.rgbString + "; border:1px solid black; " +
                    "width:1em; height:1em\">&nbsp;&nbsp;&nbsp;</span>&nbsp;&nbsp;&nbsp;" + i.name;
            items3.add(new DropDownButton.DropDownItem("colorpicker", html, new Command() {
                @Override
                public void execute() {
                    Window.alert("i am working");
                dropDownPrimary.setHTML(html);
                }
            }));
        }


        dropDownPrimary= new DropDownButton("Color Choice Property Editor", "<span style=\"background:#" + "FFFFFF" + "; border:1px solid black; " +
                "width:1em; height:1em\">&nbsp;&nbsp;&nbsp;</span>&nbsp;&nbsp;&nbsp;" + MESSAGES.noneColor(), items3, false,  false, true);

        dropDownPrimary.setStylePrimaryName("ode-ColorChoicePropertyEditor");

        // Adding PrimaryColorDark

        List<DropDownButton.DropDownItem> items4 = Lists.newArrayList();


        for( CustomColor i : YA_COLORS){
            String html = "<span style=\"background:#" + i.rgbString + "; border:1px solid black; " +
                    "width:1em; height:1em\">&nbsp;&nbsp;&nbsp;</span>&nbsp;&nbsp;&nbsp;" + i.name;
            items4.add(new DropDownButton.DropDownItem("colorpicker", html, new Command() {
                @Override
                public void execute() {
                    Window.alert("i am working");
                    dropDownPrimaryDark.setHTML(html);
                }
            }));
        }


        dropDownPrimaryDark= new DropDownButton("Color Choice Property Editor", "<span style=\"background:#" + "FFFFFF" + "; border:1px solid black; " +
                "width:1em; height:1em\">&nbsp;&nbsp;&nbsp;</span>&nbsp;&nbsp;&nbsp;" + MESSAGES.noneColor(), items4, false,  false, true);

        dropDownPrimaryDark.setStylePrimaryName("ode-ColorChoicePropertyEditor");



        List<DropDownButton.DropDownItem> items5 = Lists.newArrayList();


        for( CustomColor i : YA_COLORS){
            String html = "<span style=\"background:#" + i.rgbString + "; border:1px solid black; " +
                    "width:1em; height:1em\">&nbsp;&nbsp;&nbsp;</span>&nbsp;&nbsp;&nbsp;" + i.name;
            items5.add(new DropDownButton.DropDownItem("colorpicker", html, new Command() {
                @Override
                public void execute() {
                    Window.alert("i am working");
                    dropDownAccentColor.setHTML(html);
                }
            }));
        }


        dropDownAccentColor= new DropDownButton("Color Choice Property Editor", "<span style=\"background:#" + "FFFFFF" + "; border:1px solid black; " +
                "width:1em; height:1em\">&nbsp;&nbsp;&nbsp;</span>&nbsp;&nbsp;&nbsp;" + MESSAGES.noneColor(), items5, false,  false, true);

        dropDownAccentColor.setStylePrimaryName("ode-ColorChoicePropertyEditor");


        final FileUpload uploadWiget = new FileUpload();
        uploadWiget.getElement().setAttribute("accept", ".jpg");
        uploadWiget.setName("Upload Icon");


        VerticalPanel page = new VerticalPanel();


        HorizontalPanel subPage = new HorizontalPanel();
        subPage.add(labelTheme);
        subPage.add(dropDownTheme);
        subPage.add(labelSizing);
        subPage.add(dropDownSizing);


        HorizontalPanel subPage2 = new HorizontalPanel();
        subPage2.add(icon);
        subPage2.add(uploadWiget);
        subPage2.add(tutorialUrl);




        HorizontalPanel subPage3 = new HorizontalPanel();
        subPage3.add(versionCode);
        subPage3.add(versionName);


        HorizontalPanel subPage4 = new HorizontalPanel();
        subPage4.add(labelPrimaryColor);
        subPage4.add(dropDownPrimary);
        subPage4.add(labelPrimaryColorDark);
        subPage4.add(dropDownPrimaryDark);

//        subPage4.add(labelShowListAsJson);
//        subPage4.add(checkBoxShowListAsJson);

        HorizontalPanel subPage5 = new HorizontalPanel();
        subPage5.add(labelAccentColor);
        subPage5.add(dropDownAccentColor);
        subPage5.add(labelDefaultFileScope);
        subPage5.add(dropDownDefaultFileScope);





        VerticalPanel subPage6 = new VerticalPanel();
        subPage6.add(labelShowListAsJson);
        subPage6.add(checkBoxShowListAsJson);





        page.add(subPage);
        page.add(subPage2);
        page.add(subPage3);
        page.add(subPage4);
        page.add(subPage5);
        page.add(subPage6);
        addPage(page);




        initFinishCommand(new Command() {
            @Override
            public void execute() {




//                Window.alert(dropDownTheme.getText());
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
        super.setPagePanelHeight(230);






        DeferredCommand.addCommand(new Command() {
            public void execute() {


            }
        });
    }
}

class CustomColor{
  String name;
  String rgbString;
  String alphaString;

    CustomColor(String name,String alphaString,String rgbString){
        this.name = name;
        this.rgbString = rgbString;
        this.alphaString = alphaString;
    }


}

class CustomChoice{
    String caption;
    String value;

    public CustomChoice(String caption, String value) {
        this.caption = caption;
        this.value = value;
    }




}

