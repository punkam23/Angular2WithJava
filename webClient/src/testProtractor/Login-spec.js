/**
 * Created by yehoshuamatamorosvalverde on 28/5/17.
 */
describe('angularjs homepage todo list', function() {
    it('should add a todo', function() {
        browser.get('http://localhost:8080/');

        element(by.xpath("/html/body/my-app/bootstrap-menu/div/div/div/ul/li[2]/a")).click();
        element(by.xpath("/html/body/my-app/bootstrap-menu/div/div/div/ul/li[2]/ul/li[7]/a")).click();
        browser.pause();
        element(by.css('[ng-reflect-name="username"]')).sendKeys("yo");
        element(by.id('password')).sendKeys("yo");
        element(by.xpath("/html/body/my-app/div/bootstrap-login/div/div/div/div[4]/div/a")).click();
        browser.pause();
        // element(by.css('[value="add"]')).click();
        //
        // var todoList = element.all(by.repeater('todo in todoList.todos'));
        // expect(todoList.count()).toEqual(3);
        // expect(todoList.get(2).getText()).toEqual('write first protractor test');
        //
        // // You wrote your first test, cross it off the list
        // todoList.get(2).element(by.css('input')).click();
        // var completedAmount = element.all(by.css('.done-true'));
        // expect(completedAmount.count()).toEqual(2);
    });
});