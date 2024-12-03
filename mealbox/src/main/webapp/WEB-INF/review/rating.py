# 입력된 평점 값
rating = 3.5

# 정수 부분을 full로 저장
full = int(rating)

# 소수 부분이 0.5인지 확인하여 half 설정
half = 1 if (rating - full) == 0.5 else 0

# 결과 출력
print(f"Rating: {rating}")
print(f"Full: {full}")
print(f"Half: {half}")

for i in range(full):
    print('⭐', end='')
for i in range(half):
    print('✨')