import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns

from sklearn.preprocessing import Normalizer

df = pd.read_csv('./Wholesale customers data.csv', encoding='utf-8')

# processing
train_data = df.iloc[:, 2:]
norm_train_data = Normalizer().fit_transform(train_data)
print(norm_train_data)
