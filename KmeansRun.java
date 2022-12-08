package kmeans;
import kmeans.cluster.KmeansAdapter;
import kmeans.util.DataUtil;

import org.apache.hadoop.conf.Configuration;
import java.io.IOException;

// kmeans主方法
// 主要就是循环调用直到次数或者停机状态
// 每次循环判断下停机
// data为逗号连接
public class KmeansRun {
    public static void main(String[] args){
        // 命令行参数为数据集名称与聚类数
        String dataName = args[0];
        int k = Integer.parseInt(args[1]);
        System.out.println(k);

        String centerPath = DataUtil.HDFS_OUTPUT + "/centers.txt";
        String newCenterPath = DataUtil.HDFS_OUTPUT + "/new_centers.txt";
        String dataPath = DataUtil.HDFS_INPUT + "/" + dataName;
        String clusterResultPath = DataUtil.HDFS_OUTPUT + "/kmeans_cluster_result.txt";

        // 初始化随机中心点
        CenterRandomAdapter.createRandomCenter(dataPath, centerPath, k);
        // 默认1000次，中途停退出
        for(int i=0;i<30;i++){
            System.out.println("round " + i);
            KmeansAdapter.start(dataPath, centerPath, newCenterPath);
            if(KmeansAdapter.checkStop(centerPath, newCenterPath))
                break;
        }
        KmeansAdapter.createClusterResult(dataPath, centerPath, clusterResultPath);
    }
}