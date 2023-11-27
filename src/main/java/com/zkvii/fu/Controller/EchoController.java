package com.zkvii.fu.Controller;

import com.zkvii.fu.Dao.EchoDao;
import com.zkvii.fu.Dao.UserDao;
import com.zkvii.fu.common.EchoResponse;
import com.zkvii.fu.common.ResponseCode;
import com.zkvii.fu.forms.TableForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


@RestController
public class EchoController {
    @Autowired
    private UserDao userDao;

    @Autowired
    private EchoDao echoDao;

    // @GetMapping("")
    // public String echo() {
    //     return userDao.getAllUsers().toString();
    // }
    @GetMapping("/echo")
    public EchoResponse hello() {
        var allTables = echoDao.getAllTables();
        var allTableColumns = new HashMap<String, List<TableForm>>();
        allTables.forEach(table -> {
            allTableColumns.put(table, echoDao.getTableInfo(table));
        });
          return EchoResponse.builder()
                  .code(ResponseCode.SUCCESS)
                  .data(allTableColumns)
                  .build();
    }
}
