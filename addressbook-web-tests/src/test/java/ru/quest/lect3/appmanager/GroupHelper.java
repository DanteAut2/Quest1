package ru.quest.lect3.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.quest.lect3.model.GroupData;
import ru.quest.lect3.model.Groups;

import java.io.IOException;
import java.util.List;

public class GroupHelper extends HelperBase {

    private final ApplicationManager app;
    private Groups groupCache = null;

    public GroupHelper(ApplicationManager app) {
        super(app.wd);
        this.app = app; // сохраняем ссылку на менеджера в помощнике
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) throws IOException {
        type(By.name(app.getProperty("web.locatorGroup_name")), groupData.getName());
        type(By.name(app.getProperty("web.locatorGroup_header")), groupData.getHeader());
        type(By.name(app.getProperty("web.locatorGroup_footer")), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void deleteSelectedGroups() {
        click(By.name("delete"));
    }

    public void selectGroupById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void create(GroupData group) throws IOException {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        groupCache = null;
        returnToGroupPage();
    }

    public void modify(GroupData group) throws IOException {
        selectGroupById(group.getId());
        initGroupModification();
        fillGroupForm(group);
        submitGroupModification();
        groupCache = null;
        returnToGroupPage();
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public Groups all() {
        if (groupCache != null) {
            return new Groups(groupCache);
        }
        groupCache = new Groups();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groupCache.add(new GroupData().withId(id).withName(name));
        }
        return new Groups(groupCache);
    }

    public void delete(GroupData group) {
        selectGroupById(group.getId());
        deleteSelectedGroups();
        groupCache = null;
        returnToGroupPage();
    }
}
