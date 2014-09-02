Ext.define("app.controller.login", {
    extend: "Ext.app.Controller",
    launch: function () {
        this.callParent();
        alert(1);
    },
    init: function () {
        this.callParent();
        alert(2);
    }
});
Ext.application({
    name: "app",
    controllers: ["login"],
    views: ["index"],

    launch: function () {

        var notesListContainer = Ext.create("app.index");
        Ext.Viewport.add(notesListContainer);
    }
});
