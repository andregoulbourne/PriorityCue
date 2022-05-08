Ext.define('MyExtGenApp.view.item.ItemViewStore', {
    extend: 'Ext.data.Store',
    alias: 'store.itemviewstore',
    fields: [
        'name', 'priority', 'date', 'summary', 'price', 'wave'
    ],
    groupField: 'priority',
    proxy: {
        type: 'ajax',
        url: 'http://localhost:8081/items',
        reader: {
            type: 'json',
            rootProperty: 'data'
        }
    },
    autoLoad: true
});
