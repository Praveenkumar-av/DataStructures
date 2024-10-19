def expected_swims(N, M, X, Y):
    E = [[0.0] * M for _ in range(N + 1)]

    for i in range(N - 1, -1, -1):
        for j in range(M):
            expected_value = 0.0
            count = 0
            
            if j > 0:
                expected_value += E[i][j - 1]
                count += 1
            
            if j < M - 1:
                expected_value += E[i][j + 1]
                count += 1
            
            expected_value += E[i + 1][j]
            count += 1
            
            expected_value += E[i][j]
            count += 1
            
            E[i][j] = 1 + expected_value / count

    return E[X][Y]

N = 5  # depth
M = 5  # width
X = 2  # current depth
Y = 2  # current width
result = expected_swims(N, M, X, Y)
print(f"Expected number of swims: {result:.6f}")
