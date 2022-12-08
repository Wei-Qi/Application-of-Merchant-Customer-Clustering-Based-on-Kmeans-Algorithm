# 云计算与并行技术 课程设计
## 一、数据预处理

数据集

![1669904529345](course-report.assets/1669904529345.png)



聚类时只用到后6个特征

1) FRESH: annual spending (m.u.) on fresh products (Continuous);
2) MILK: annual spending (m.u.) on milk products (Continuous);
3) GROCERY: annual spending (m.u.)on grocery products (Continuous);
4) FROZEN: annual spending (m.u.)on frozen products (Continuous)
5) DETERGENTS_PAPER: annual spending (m.u.) on detergents and paper products (Continuous)
6) DELICATESSEN: annual spending (m.u.)on and delicatessen products (Continuous); 

![1669904752613](course-report.assets/1669904752613.png)

 

可以发现Fresh列到Delicassen列的数据数量级大小差别很大，在聚类前需要进行标准化 ，因此将特征归一化到0-1区间内

![1669904718047](course-report.assets/1669904718047.png)



至此数据处理完毕，将矩阵导出为文件

![1669905086064](course-report.assets/1669905086064.png)



## 二、Experiment

硬件配置：

> Master x1  CPU-core 4  Memory 4G Disk 100G
>
> Slave    x1  CPU-core 4  Memory 4G Disk 100G

参数配置

> k = 3, 4, 5, 6
>
> epoch 30
>
> map worker x2  reduce worker x1



首先介绍实验运行的过程，然后再分别针对不同cluster个数的结果进行分析



我们将输入文件夹和输出文件夹分别设置为input和output，并将数据集上传至hdfs

![1669952246937](course-report.assets/1669952246937.png)



![1669952440043](course-report.assets/1669952440043.png)



将java代码导出为jar包后，开始运行

hadoop jar kmeans.jar kmeans.KmeansRun train_data.txt 3 

![1669905843504](course-report.assets/1669905843504.png)



运行结束

![1669906227885](course-report.assets/1669906227885.png)



查看结果可以发现输出文件夹中多了初始聚类中心、聚类结果以及最终聚类中心

![1669906301707](course-report.assets/1669906301707.png)



我们将结果从hdfs上下到本地

![1669907007560](course-report.assets/1669907007560.png)



### 2.1 cluster=3

聚类结果

![1669946538719](course-report.assets/1669946538719.png)

类别统计

![1669947166922](course-report.assets/1669947166922.png)

聚类中心

![1669947221574](course-report.assets/1669947221574.png)

可视化 散点矩阵图

![1669951672935](course-report.assets/1669951672935.png)



### 2.2 cluster=4

聚类结果

![1669951769753](course-report.assets/1669951769753.png)

类别统计

![1669951776594](course-report.assets/1669951776594.png)

聚类中心

![1669951788175](course-report.assets/1669951788175.png)

可视化 散点矩阵图

![1669951745344](course-report.assets/1669951745344.png)



### 2.3 cluster=5

聚类结果

![1669952113077](course-report.assets/1669952113077.png)

类别统计

![1669952105378](course-report.assets/1669952105378.png)

聚类中心

![1669952120468](course-report.assets/1669952120468.png)

可视化 散点矩阵图

![1669951913161](course-report.assets/1669951913161.png)



### 2.4 cluster=6

聚类结果

![1669952074118](course-report.assets/1669952074118.png)

类别统计

![1669952065449](course-report.assets/1669952065449.png)

聚类中心

![1669952023215](course-report.assets/1669952023215.png)

可视化 散点矩阵图

![](course-report.assets/1669952057897.png)

