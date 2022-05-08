Ext.define('MyExtGenApp.view.item.ItemView',{
    extend: 'Ext.grid.Grid',
    xtype: 'itemview',
    cls: 'itemview',
    requires: ['Ext.grid.rowedit.Plugin'],
    controller: {type: 'itemviewcontroller'},
    viewModel: {type: 'itemviewmodel'},
    store: {type: 'itemviewstore'},
    grouped: true,
    groupFooter: {
        xtype: 'gridsummaryrow'
    },
    plugins: {
        rowedit: {
            autoConfirm: false
        }
    },
    columns: [
        {
            text: 'Name',
            dataIndex: 'name',
            editable: true,
            width: 100,
            cell: {userCls: 'bold'}
        },
        {
            text: 'Priority',
            dataIndex: 'priority',
            editable: true, 
            width: 230
        },{
            text: 'Date',
            dataIndex: 'date',
            editable: true,
            width: 150
        },{
            text: 'Summary',
            dataIndex: 'summary',
            editable: true,
            width: 150
        },{
            text: 'Price',
            dataIndex: 'price',
            editable: true,
            width: 150
        },{
            text: 'Wave',
            dataIndex: 'wave',
            editable: true,
            width: 150
        }
    ],
    listeners: {
        canceledit: 'onEditCancelled'
    }
});
