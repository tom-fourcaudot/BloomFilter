import pandas as pd
import matplotlib.pyplot as plt
import numpy as np

df = pd.read_csv('BloomFilter/error.csv')
M = df['M'].drop_duplicates().values.tolist()
K = ["K=1", "K=3", "k=5"]
print(df)
k1 = df.loc[df['M']==10000]['error'].tolist()

k2 = df.loc[df['M']==100000]['error'].tolist()
k3 = df.loc[df['M']==1000000]['error'].tolist()
data = [k1, k2, k3]
print(data)

X = np.arange(3)
plt.figure(1)
plt.bar(X + 0.00, data[0], color = 'b', width = 0.25, label=M[0])
plt.bar(X + 0.25, data[1], color = 'g', width = 0.25, label=M[1])
plt.bar(X + 0.50, data[2], color = 'r', width = 0.25, label=M[2])
plt.xticks(X, K)
plt.title('% d\'erreur')
plt.xlabel("Nb of Hash function (k)")
plt.ylabel("% of errors")

plt.legend(loc='best', title="Filter size")
plt.show()