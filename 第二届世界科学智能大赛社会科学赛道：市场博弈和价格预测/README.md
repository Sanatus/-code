操作系统版本:Windows 11 家庭中文版22631.3880
Python版本：3.7.1
Python package:
    import pandas as pd
    import numpy as np
    from math import pi
    from pathlib import Path
    import matplotlib.pyplot as plt
    import seaborn as sns
    import plotly.graph_objects as go
    from plotly.subplots import make_subplots

    from sklearn import preprocessing
    from sklearn.preprocessing import OneHotEncoder
    from sklearn.model_selection import train_test_split
    from sklearn.metrics import mean_absolute_percentage_error
    from sklearn.feature_extraction.text import TfidfVectorizer, CountVectorizer
    from sklearn.model_selection import TimeSeriesSplit

    import lightgbm as lgb
    from lightgbm import LGBMRegressor
    import xgboost as xgb
    from xgboost import XGBRegressor
    from sklearn.linear_model import LinearRegression
    from sklearn.ensemble import RandomForestRegressor
    from sklearn.linear_model import LinearRegression
    import optuna

    from sklearn.model_selection import KFold, train_test_split,RepeatedKFold
    from sklearn.metrics import mean_squared_error
    from sklearn.metrics import mean_absolute_error
    from sklearn.metrics import r2_score
    from tqdm import tqdm 

    import logging
    logging.basicConfig(format='%(asctime)s : %(levelname)s : %(message)s', level=logging.INFO)

    import warnings
    warnings.simplefilter("ignore")