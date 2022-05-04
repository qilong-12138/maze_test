public class todo_maze {

    public static void main(String[] args) {
        // 首先设定两个迷宫，确保程序不是偶然并且可运行
        int maze[][] = {
                {0, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1},
                {1, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 1, 1},
                {0, 1, 0, 0, 0, 0}
        };
        int maze0[][] = {
                {0, 1, 1, 0, 0, 1},
                {0, 0, 0, 1, 0, 1},
                {1, 0, 1, 0, 0, 1},
                {0, 0, 0, 1, 0, 1},
                {0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 1}
        };

        // 直接调用解决函数，设定迷宫，设定起始点，设定终点
        Point.queueToAnswer(maze, new Point(0, 0), new Point(3, 5));
        // 设置输出矩阵
        StringBuffer str = new StringBuffer();
        // 将原本的标记转换成可视图
        for (int[] value : maze) {
            for (int j = 0; j < maze[0].length; j++) {
                if (value[j] == 0) {
                    str.append("◻\t");
                } else if (value[j] == 1) {
                    str.append("◼\t");
                } else {
                    str.append("*\t");
                }
            }
            str.append("\r\n");
        }
        // 将结果打印出来
        System.out.println("迷宫一：");
        System.out.println(str);


        // 直接调用解决函数，设定迷宫，设定起始点，设定终点
        Point.queueToAnswer(maze0, new Point(0, 0), new Point(4, 5));
        // 设置输出矩阵
        StringBuffer str0 = new StringBuffer();
        // 将原本的标记转换成可视图
        for (int[] ints : maze0) {
            for (int j = 0; j < maze0[0].length; j++) {
                if (ints[j] == 0) {
                    str0.append("◻\t");
                } else if (ints[j] == 1) {
                    str0.append("◼\t");
                } else {
                    str0.append("*\t");
                }
            }
            str0.append("\r\n");
        }
        // 将结果打印出来
        System.out.println("迷宫二：");
        System.out.println(str0);
    }
}




