import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Project name(项目名称)：算法_二分搜索搜索数组
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/13
 * Time(创建时间)： 22:09
 * Version(版本): 1.0
 * Description(描述)：
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组[0,1,2,4,5,6,7]可能变为[4,5,6,7,0,1,2])。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它在数组中的下标，否则返回 -1 。
 * <p>
 * 已知的是，数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(logn) 级别。
 * <p>
 * 样例1：
 * <p>
 * 测试输入: n = 7 , nums = [4,5,6,7,0,1,2], T = 0
 * <p>
 * 预期输出: 4
 * <p>
 * 样例2：
 * <p>
 * 测试输入: n = 7 , nums = [4,5,6,7,0,1,2], T = 3
 * <p>
 * 预期输出: -1
 */

public class test
{
    public int search(int n, int[] nums, int T)
    {
        /********* Begin *********/
        return search(nums, 0, nums.length - 1, T);   //为了使用递归
        /********* End *********/
    }

    private int search(int[] nums, int low, int high, int target)
    {
        if (low > high)               //直接返回-1
        {
            return -1;
        }
        int mid = (low + high) / 2;    //中间位
        if (nums[mid] == target)       //刚好在中间
        {
            return mid;
        }
        if (nums[mid] < nums[high])    //右侧有序
        {
            if (target > nums[mid] && target <= nums[high])  //目标值在右侧
            {
                return search(nums, mid + 1, high, target);
            }
            else                        //左边
            {
                return search(nums, low, mid - 1, target);
            }
        }
        else                          //左侧有序
        {
            if (target < nums[mid] && target >= nums[low])    //左
            {
                return search(nums, low, mid - 1, target);
            }
            else
            {
                return search(nums, mid + 1, high, target);  //右
            }
        }
    }


    public static void main(String[] args)
    {
        if (args.length == 0)
        {
            Scanner input = new Scanner(System.in);
            int n = 0;
            //控制台输入变量:n
            int errCount = 0;
            while (true)
            {
                try
                {
                    //min:0
                    //max:1000
                    System.out.print("请输入数组个数：");
                    n = input.nextInt();
                    if (n >= 0 && n <= 1000)
                    {
                        break;
                    }
                    else
                    {
                        errCount++;
                        Toolkit.getDefaultToolkit().beep();
                        if (errCount > 10)
                        {
                            System.err.println("错误次数过多！！！退出");
                            System.exit(1);
                        }
                        System.out.println("输入的数据不在范围内! 范围：[0,1000]");
                    }
                }
                catch (Exception e)
                {
                    errCount++;
                    if (errCount > 5)
                    {
                        Toolkit.getDefaultToolkit().beep();
                        System.err.println("错误次数过多！！！退出");
                        System.exit(1);
                    }
                    else
                    {
                        Toolkit.getDefaultToolkit().beep();
                        System.out.println("输入错误！！！请重新输入！");
                        input.nextLine();
                    }
                }
            }
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++)
            {
                //控制台输入变量:arr[i]
                errCount = 0;
                while (true)
                {
                    try
                    {
                        //min:-1000000
                        //max:1000000
                        System.out.print("请输入第" + (i + 1) + "个数字：");
                        arr[i] = input.nextInt();
                        if (arr[i] >= -10000 && arr[i] <= 1000000)
                        {
                            break;
                        }
                        else
                        {
                            errCount++;
                            Toolkit.getDefaultToolkit().beep();
                            if (errCount > 10)
                            {
                                System.err.println("错误次数过多！！！退出");
                                System.exit(1);
                            }
                            System.out.println("输入的数据不在范围内! 范围：[-10000,1000000]");
                        }
                    }
                    catch (Exception e)
                    {
                        errCount++;
                        if (errCount > 5)
                        {
                            Toolkit.getDefaultToolkit().beep();
                            System.err.println("错误次数过多！！！退出");
                            System.exit(1);
                        }
                        else
                        {
                            Toolkit.getDefaultToolkit().beep();
                            System.out.println("输入错误！！！请重新输入！");
                            input.nextLine();
                        }
                    }
                }
            }

            int search_key;
            //控制台输入变量:search_key
            errCount = 0;
            while (true)
            {
                try
                {
                    //min:-1000000
                    //max:1000000
                    System.out.println("请输入要查找的数字：");
                    search_key = input.nextInt();
                    if (search_key >= -1000000 && search_key <= 1000000)
                    {
                        break;
                    }
                    else
                    {
                        errCount++;
                        Toolkit.getDefaultToolkit().beep();
                        if (errCount > 10)
                        {
                            System.err.println("错误次数过多！！！退出");
                            System.exit(1);
                        }
                        System.out.println("输入的数据不在范围内! 范围：[-1000000,1000000]");
                    }
                }
                catch (Exception e)
                {
                    errCount++;
                    if (errCount > 5)
                    {
                        Toolkit.getDefaultToolkit().beep();
                        System.err.println("错误次数过多！！！退出");
                        System.exit(1);
                    }
                    else
                    {
                        Toolkit.getDefaultToolkit().beep();
                        System.out.println("输入错误！！！请重新输入！");
                        input.nextLine();
                    }
                }
            }

            test t = new test();
            int result = -1;
            System.out.println("数组：");
            for (int i = 0; i < arr.length; i++)
            {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            System.out.println("关键字：" + search_key);
            result = t.search(n, arr, search_key);
            System.out.println("结果：" + result);
        }
        else if (args.length >= 2)
        {
            int[] arr = new int[args.length - 1];
            int search_key = -1;
            try
            {
                search_key = Integer.parseInt(args[args.length - 1]);
                for (int i = 0; i < args.length - 1; i++)
                {
                    arr[i] = Integer.parseInt(args[i]);
                }

                System.out.println("数组：");
                for (int i = 0; i < arr.length; i++)
                {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
                System.out.println("搜索关键字：" + search_key);
                test t = new test();
                int result = -1;
                result = t.search(arr.length, arr, search_key);
                System.out.println("结果：" + result);
            }
            catch (Exception e)
            {
                Toolkit.getDefaultToolkit().beep();
                System.out.println("参数传递异常！！！可能传递了非数字");
            }
        }
        else
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("参数传递错误！！！参数太少,至少为2个");
        }

    }
}
