package org.example;

/**
 * 测试系统的GUI
 *
 * @version 2023/5/30 15:21
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtripSearchTestGUI extends JFrame {
    private JButton singleTestButton1;
    private JButton singleTestButton2;
    private JButton singleTestButton3;
    private JButton integrationTest1;
    private JButton integrationTest2;
    private JButton datatest;
    private JTextArea resultTextArea;

    public CtripSearchTestGUI() {
        setTitle("携程搜索功能测试");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // 创建测试按钮
        singleTestButton1 = new JButton("执行模块测试1");
        singleTestButton2 = new JButton("执行模块测试2");
        singleTestButton3 = new JButton("执行模块测试3");
        integrationTest1 = new JButton("执行集成测试1");
        integrationTest2 = new JButton("执行集成测试2");

        singleTestButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeTest1();
            }
        });
        singleTestButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeTest2();
            }
        });
        singleTestButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeTest3();
            }
        });
        integrationTest1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeTest4();
            }
        });
        integrationTest2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeTest5();
            }
        });


        // 创建结果文本区域
        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultTextArea);

        // 将测试按钮和结果文本区域添加到界面
        add(singleTestButton1);add(singleTestButton2);add(singleTestButton3);
        add(integrationTest1);add(integrationTest2);
        add(scrollPane);
    }

    private void executeTest1() {
        // 执行测试代码
        CtripSearchTest ctripSearchTest = new CtripSearchTest();
        ctripSearchTest.setUp();
        ctripSearchTest.singleModuleTest1();
        ctripSearchTest.tearDown();
        // 模拟测试结果
        String testResult = "测试结果:\n测试通过！";
        // 将测试结果输出到文本区域
        resultTextArea.setText(testResult);
    }
    private void executeTest2() {
        // 执行测试代码
        CtripSearchTest ctripSearchTest = new CtripSearchTest();
        ctripSearchTest.setUp();
        ctripSearchTest.singleModuleTest2();
        ctripSearchTest.tearDown();
        // 模拟测试结果
        String testResult = "测试结果:\n测试通过！";
        // 将测试结果输出到文本区域
        resultTextArea.setText(testResult);
    }
    private void executeTest3() {
        // 执行测试代码
        CtripSearchTest ctripSearchTest = new CtripSearchTest();
        ctripSearchTest.setUp();
        ctripSearchTest.singleModuleTest3();
        ctripSearchTest.tearDown();
        // 模拟测试结果
        String testResult = "测试结果:\n测试通过！";
        // 将测试结果输出到文本区域
        resultTextArea.setText(testResult);
    }
    private void executeTest4() {
        // 执行测试代码
        CtripSearchTest ctripSearchTest = new CtripSearchTest();
        ctripSearchTest.setUp();
        ctripSearchTest.integrationTest1();
        ctripSearchTest.tearDown();
        // 模拟测试结果
        String testResult = "测试结果:\n测试通过！";
        // 将测试结果输出到文本区域
        resultTextArea.setText(testResult);
    }
    private void executeTest5() {
        // 执行测试代码
        CtripSearchTest ctripSearchTest = new CtripSearchTest();
        ctripSearchTest.setUp();
        ctripSearchTest.integrationTest2();
        ctripSearchTest.tearDown();
        // 模拟测试结果
        String testResult = "测试结果:\n测试通过！";
        // 将测试结果输出到文本区域
        resultTextArea.setText(testResult);
    }

}

