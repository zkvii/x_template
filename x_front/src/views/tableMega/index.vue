<template>
  <div class="container" style="margin: 20px">
    <div class="head-container" style="margin: 20px">
      <el-button
        type="primary"
        icon="el-icon-plus"
        @click="addTab"
      >
        添加表
      </el-button>
    </div>
    <el-tabs v-model="editableTabsValue" type="border-card" closable @tab-remove="removeTab">
      <el-tab-pane
        v-for="(item, index) in editableTabs"
        :key="item.name"
        :name="item.name"
      >
        <span slot="label">
          <i class="el-icon-document" style="margin: 2px"></i>
           <span >{{ item.tableName }}</span>
        </span>
        <el-card class="box-card" style="width: 100%">
          <div slot="header" class="clearfix">
            <el-input  v-model="item.tableName"></el-input>
          </div>
          <div>
            <el-table
              ref="multipleTable"
              :data="activateTableData"
              style="width: 75%"
              @selection-change="handleSelectionChange">
              <el-table-column
                type="selection"
                width="55">
              </el-table-column>
              <el-table-column
                label="columnName"
                width="140"
                property="columnName"
              >
              </el-table-column>
              <el-table-column
                property="columnType"
                label="columnType"
                width="150">
              </el-table-column>
              <el-table-column
                property="columnComment"
                label="columnComment"
                width="150"
                show-overflow-tooltip>
              </el-table-column>
              <el-table-column
                property="columnJavaName"
                label="columnJavaName"
                width="150"
                show-overflow-tooltip>
              </el-table-column>
              <el-table-column
                property="columnJavaType"
                label="columnJavaType"
                width="150"
                show-overflow-tooltip>
              </el-table-column>
              <el-table-column
                label="isNullable"
                width="150"
                show-overflow-tooltip>
                <template v-slot="scope">
                  <el-switch v-model="scope.row.isNullable"></el-switch>
                </template>
              </el-table-column>
            </el-table>
            <div style="margin-top: 20px">
              <el-button type="primary" icon="el-icon-plus" @click="addColumn">添加字段</el-button>
              <el-button type="success" icon="el-icon-lollipop" @click="exportTemplate">生成entity模板</el-button>
              <el-button type="danger" icon="el-icon-delete" @click="deleteColumns">删除字段</el-button>

            </div>
          </div>
        </el-card>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>


export default {
  name: 'Dashboard',

  data() {
    return {
      editing: false,
      editableTabs: [
        {tableName: 'tableName',
        name: '0',
        editable: false
        }
      ],
      editableTabsValue: '0',
      tabIndex: 0,
      activateTableData: [
        {
          columnName: 'name',
          columnType: 'varchar(255)',
          columnComment: '姓名',
          columnJavaName: 'name',
          isNullable: '否'
        },
        {
          columnName: 'name',
          columnType: 'varchar(255)',
          columnComment: '姓名',
          columnJavaName: 'name',
          isNullable: false
        },
   ],
      multipleSelection: []
    }
  },
  computed: {

  },
  created() {

  },
  methods: {
    // toggleSelection(rows) {
    //   if (rows) {
    //     rows.forEach(row => {
    //       this.$refs.multipleTable.toggleRowSelection(row);
    //     });
    //   } else {
    //     this.$refs.multipleTable.clearSelection();
    //   }
    // },
    addColumn(){
      this.activateTableData.push(
        {
          columnName: 'tempColumn',
          columnType: 'varchar(255)',
          columnJavaName: 'tempJava',
          columnComment: 'temp',
          isNullable: true
        }
      )
    },
    deleteColumns(){
      this.activateTableData=this.activateTableData.filter(item=> !this.multipleSelection.some(removeItem=>removeItem.columnName!==item.columnName)
      )
      // console.log(this.multipleSelection)
    },
    exportTemplate(){

    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    addTab() {
      let newTabName = ++this.tabIndex + '';
      this.editableTabs.push({
        tableName: newTabName+'_table_name',
        name: newTabName,
        editable: false
      });
      this.editableTabsValue = newTabName;
    },
    removeTab(targetName) {
      let tabs = this.editableTabs;
      let activeName = this.editableTabsValue;
      if (activeName === targetName) {
        tabs.forEach((tab, index) => {
          if (tab.name === targetName) {
            let nextTab = tabs[index + 1] || tabs[index - 1];
            if (nextTab) {
              activeName = nextTab.name;
            }
          }
        });
      }
      this.editableTabsValue = activeName;
      this.editableTabs = tabs.filter(tab => tab.name !== targetName);
    }
  }
}
</script>
<style lang="scss">
.text {
  font-size: 14px;
}

.item {
  margin-bottom: 18px;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}
.clearfix:after {
  clear: both
}

.box-card {
  width: 480px;
}
</style>
