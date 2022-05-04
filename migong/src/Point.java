import java.util.LinkedList;
import java.util.Queue;

// 对于Point类设置基本的属性，并且对其进行封装
public class Point {
    private int x,y;
    // 建立point
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    // 封装X
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    // 封装Y
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    // 方向向左
    public Point left(){
        if(this.getY()==0)
            return null;
        return new Point(this.getX(),this.getY()-1);
    }
    // 方向向右
    public Point right(){
        return new Point(this.getX(),this.getY()+1);
    }
    // 方向向上
    public Point up(){
        if(this.getX()==0)
            return null;
        return new Point(this.getX()-1,this.getY());
    }
    // 方向向下
    public Point down(){
        return new Point(this.getX()+1,this.getY());
    }

    // 对坐标进行哈希，确保其唯一性
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.getX();
        result = 31 * result + this.getY();
        return result;
    }

    // 满足函数
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof Point)) return false;
        if(obj.hashCode()!=this.hashCode()) return false;
        Point p = (Point) obj;
        return (p.getY() == this.getY()) && (p.getX() == this.getX());
    }

    // 用队列进行求解的全过程
    // 分治法体现在将大的迷宫转换成为了一个点的上下左右四个方向的处理问题。
    public static String queueToAnswer(int maze[][], Point in_it, Point out_it){

        Point [][]mark = new Point[maze.length][maze[0].length];
        //创建队列
        Queue<Point> queue = new LinkedList<Point>();
        //标记入口
        mark[in_it.getX()][in_it.getY()] = in_it;
        queue.offer(in_it);

        while(!queue.isEmpty()){
            // 确定条件
            Point p = queue.poll();
            // 向上走试试
            Point n = p.up();
            // 对于上面的点进行判断
            if( n != null && maze[n.getX()][n.getY()] == 0 && mark[n.getX()][n.getY()] == null){
                mark[n.getX()][n.getY()] = p;
                // 要是已经到头了，结束
                if(n.equals(out_it)){
                    break;
                }
                // 合适的就进队列
                queue.offer(n);
            }
            // 向下走试试
            n = p.down();
            // 对于下面的点进行判断
            if((n.getX() < maze.length) && maze[n.getX()][n.getY()] == 0 && mark[n.getX()][n.getY()] == null){
                mark[n.getX()][n.getY()] = p;
                // 要是已经到头了，结束
                if(n.equals(out_it)){
                    break;
                }
                // 合适的就进队列
                queue.offer(n);
            }
            // 向左走试试
            n = p.left();
            // 对于左面的点进行判断
            if((n !=null) && maze[n.getX()][n.getY()] == 0 && mark[n.getX()][n.getY()] == null){
                mark[n.getX()][n.getY()] = p;
                // 要是已经到头了，结束
                if(n.equals(out_it)){
                    break;
                }
                // 合适的就进队列
                queue.offer(n);
            }
            // 向右走试试
            n = p.right();
            // 对于右面的点进行判断
            if((n.getY() < maze[0].length) && maze[n.getX()][n.getY()] == 0 && mark[n.getX()][n.getY()] == null){
                mark[n.getX()][n.getY()] = p;
                // 要是已经到头了，结束
                if(n.equals(out_it)){
                    break;
                }
                // 合适的就进队列
                queue.offer(n);
            }
        }


        // 对于成功走的路径进行标记
        Point p = out_it;
        while(p != in_it){
            maze[p.getX()][p.getY()] = 3;
            p = mark[p.getX()][p.getY()];
        }
        maze[p.getX()][p.getY()] = 3;
        // 创建矩阵展示
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<maze.length;i++) {
            for (int j = 0; j < maze[0].length; j++) {
                stringBuffer.append(maze[i][j]);
            }
           stringBuffer.append("\r\n");
        }
        // 返回矩阵展示
        return stringBuffer.toString();
    }

}
