Ext.application({
    name: 'Sencha',

    launch: function() {
        Ext.create("Ext.tab.Panel", {
            fullscreen: true,
            tabBarPosition: 'bottom',

            items: [// 这次，我们将三个栏目当成三个Tab Panel的成员
                {// 第一个成员，home页面
                    title: 'Index',
                    iconCls: 'home',
                    cls: 'home',
                    html: [
                        '<img src="images/sencha.png" />',
                        '<h1>Welcome to Sencha Touch</h1>',
                        "<p>You're creating the Getting Started app. This demonstrates how ",
                        "to use tabs, lists and forms to create a simple app</p>",
                        '<h2>Sencha Touch 2</h2>'
                    ].join("")
                },
                {// 第二个成员，blog页面
                    xtype: 'nestedlist',
                    title: 'Case',
                    iconCls: 'star',
                    displayField: 'title',

                    store: {
                        type: 'tree',

                        fields: [
                            'title', 'link', 'author', 'contentSnippet', 'content',
                            {name: 'leaf', defaultValue: true}
                        ],

                        root: {
                            leaf: false
                        },

                        proxy: {
                            type: 'jsonp',
                            url: '#',
                            reader: {
                                type: 'json',
                                rootProperty: 'responseData.feed.entries'
                            }
                        }
                    },

                    detailCard: {
                        xtype: 'panel',
                        scrollable: true,
                        styleHtmlContent: true
                    },

                    listeners: {
                        itemtap: function(nestedList, list, index, element, post) {
                            this.getDetailCard().setHtml(post.get('content'));
                        }
                    }
                },
                {// 第三个成员，Contact页面
                    title: 'Contact',
                    iconCls: 'user',
                    xtype: 'formpanel',
                    url: 'contact.php',
                    layout: 'vbox',

                    items: [
                        {
                            xtype: 'fieldset',
                            title: '登录',
                            region: 'center',
                            instructions: '(email address is optional)',
                            width:'device-width' ,
                            items: [
                                {
                                	xtype : 'textfield',
                					name : 'name',
                					id:'userName',
                					label : '账号',
                					useClearIcon : true,
                					autoCapitalize : false 
                                },
                                {
                                	xtype : 'passwordfield',
                					name : 'password',
                					id:'password',
                					label : '密码',
                					useClearIcon : false
                                },
                                {
                                	xtype : 'emailfield',
                					name : 'Email',
                					id:'email',
                					label : '邮件',
                					useClearIcon : false
                                } 
                            ]
                        },
                        {
                            xtype: 'button',
                            text: '保存',
                            ui: 'confirm',
                            handler: function() {
                            	loginAction();
                                //this.up('formpanel').submit();
                            }
                        }
                    ]
                }
            ]
        });
    }
});
