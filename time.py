import matplotlib.pyplot as plt
import pandas as pd
import numpy as np

df = pd.read_csv("BloomFilter/time.csv")


arrayFilter = df.loc[df['type']==0]
listFilter = df.loc[df['type']==1]
linkFilter = df.loc[df['type']==2]


M = df['M'].drop_duplicates().values.tolist()
K = df['K'].drop_duplicates().values.tolist()
i = 1
for nb in K:
    plt.figure(i)
    plt.title(f"K = {nb}")
    plt.plot(M, arrayFilter.loc[arrayFilter['K']==nb]['time'].values.tolist(), label="Array")
    plt.plot(M, listFilter.loc[listFilter['K']==nb]['time'].values.tolist(), label="arrayList")
    plt.plot(M, linkFilter.loc[linkFilter['K']==nb]['time'].values.tolist(), label="linked list")
    plt.xlabel('Nb elements')
    plt.ylabel('Time')
    plt.legend()
    i+=1

plt.figure(4)
plt.title("K = 5")
plt.plot(M, arrayFilter.loc[arrayFilter['K']==5]['time'].values.tolist(), label="Array")
plt.plot(M, listFilter.loc[listFilter['K']==5]['time'].values.tolist(), label="arrayList")
plt.xlabel('Nb elements')
plt.ylabel('Time')
plt.legend()
i+=1

for s in M:
    plt.figure(i)
    plt.title(f"M = {s}")
    plt.plot(K, arrayFilter.loc[arrayFilter['M']==s]['time'].values.tolist(), label="Array")
    plt.plot(K, listFilter.loc[listFilter['M']==s]['time'].values.tolist(), label="arrayList")
    plt.plot(K, linkFilter.loc[linkFilter['M']==s]['time'].values.tolist(), label="linked list")
    plt.xlabel('k')
    plt.ylabel('Time')
    plt.legend()
    i+=1

plt.figure(i)
plt.title(f"M = {s}")
plt.plot(K, arrayFilter.loc[arrayFilter['M']==s]['time'].values.tolist(), label="Array")
plt.plot(K, listFilter.loc[listFilter['M']==s]['time'].values.tolist(), label="arrayList")
plt.xlabel('k')
plt.ylabel('Time')
plt.legend()

plt.show()
