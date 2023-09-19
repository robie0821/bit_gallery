# bit_gallery
각 수정 내역에 대한 설명을 추가하여 어떤 기능을 구현했는지 상세히 설명하겠습니다:

1. HTML 폼에서 `작가(artist)` 값을 넘기도록 설정했습니다.
   - 사용자가 게시글을 작성할 때 작가 정보를 함께 입력할 수 있도록 HTML 폼을 수정했습니다.
   (* NOT NULL로 인해 수정. 디폴트값 지정 등 추가적인 해결 필요)

2. `/article/add` 엔드포인트에서 `photofile` 필드를 `photofile`로 변경했습니다.
   - 게시글을 추가할 때 사진 파일을 업로드할 수 있도록 `photofile` 필드의 이름을 변경했습니다.
(*컬럼값 불일치)

3. `Required request part 'photofile' is not present` 오류를 해결하기 위해 `<input type='file' name='photofile' multiple>` 필드를 추가했습니다.
   - 파일 업로드를 위한 `photofile` 필드를 HTML 폼에 추가하여 파일 업로드를 가능하게 했습니다.
   (*컬럼값 불일치 및 타임리프 문법 수정함)

4. `/article/update` 엔드포인트에서 `photofile` 필드를 `photofile`로 변경했습니다.
   - 게시글을 수정할 때 사진 파일을 업로드할 수 있도록 `photofile` 필드의 이름을 변경했습니다.
(*컬럼값 불일치)

