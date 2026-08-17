# `kmp-shared-components` Phase 1 Task List

## Repository

```text
kmp-shared-components
```

このファイルには **KMP Repositoryで実行する作業だけ** を記載する。

Native画面、Android Navigation、SwiftUI Navigationなどはここでは実装しない。

---

# 0. Phase 1 KMP Scope

## KMP側で行う

- Compose Multiplatform環境構築
- Component実装
- Component用Model定義
- Android向け公開
- iOS向け`UIViewController` factory公開
- Android artifact生成
- iOS XCFramework生成
- KMP側で必要なComponentテスト

## KMP側では行わない

```text
Android Navigation Compose の画面構築
Android ViewModel / Screen State
SwiftUI NavigationStack
SwiftUI TabView
SwiftUI @State
UIViewControllerRepresentable
Native BackStack
Native Dummy Data の所有
```

---

# 1. Milestone KMP-1: Project / Targets 構築

- [ ] `[KMP]` `kmp-shared-components` Repositoryを作成
- [ ] `[KMP]` Kotlin Multiplatform Plugin設定
- [ ] `[KMP]` Compose Multiplatform Plugin設定
- [ ] `[KMP]` Android Target設定
- [ ] `[KMP]` iOS Target設定
- [ ] `[KMP]` `commonMain` 作成・確認
- [ ] `[KMP]` `androidMain` 作成・確認
- [ ] `[KMP]` `iosMain` 作成・確認
- [ ] `[KMP]` 最小Themeを作成
- [ ] `[KMP]` Android artifactをbuildできる
- [ ] `[KMP]` iOS Framework / XCFrameworkをbuildできる

## Done Condition

```text
Android artifact build SUCCESS
AND
iOS XCFramework build SUCCESS
```

---

# 2. Milestone KMP-2: PrimaryButton Vertical Slice

> Phase 1で最も重要なMilestone。
> このMilestoneがNative両方で確認されるまでは、他Componentを実装しない。

## Component

```kotlin
@Composable
fun PrimaryButton(
    title: String,
    enabled: Boolean = true,
    onClick: () -> Unit,
)
```

## Tasks

- [ ] `[KMP]` `PrimaryButton` 実装
- [ ] `[KMP]` `title` を外部入力にする
- [ ] `[KMP]` `enabled` を外部入力にする
- [ ] `[KMP]` `onClick` callbackを外部へ返す
- [ ] `[KMP]` Androidから`@Composable`として利用可能にする
- [ ] `[KMP]` iOS向け`PrimaryButtonViewController(...)`を作成
- [ ] `[KMP]` `ComposeUIViewController`内で`PrimaryButton`を表示
- [ ] `[KMP]` Android artifactを再生成
- [ ] `[KMP]` XCFrameworkを再生成

## Native確認待ち

この後、以下が完了するまで次Componentへ進まない。

- [ ] `[WAIT: ANDROID]` Androidで表示 + callback成功
- [ ] `[WAIT: IOS]` SwiftUIで表示 + callback成功

---

# 3. Milestone KMP-3: Basic Components

Native両方のPrimaryButton Integration成功後に開始。

## ItemCard

- [ ] `[KMP]` `ItemCardModel` 定義
- [ ] `[KMP]` `ItemCard` 実装
- [ ] `[KMP]` Native固有画像型をAPIに含めない
- [ ] `[KMP]` placeholder / Multiplatform Resource / Vector Iconを利用
- [ ] `[KMP]` `onClick` が必要ならcallback化
- [ ] `[KMP]` iOS向けHost factoryを用意

## AppTopAppBar

- [ ] `[KMP]` `title`入力
- [ ] `[KMP]` `showBackButton`入力
- [ ] `[KMP]` `onBackClick` callback
- [ ] `[KMP]` KMP側でBackStackを操作しない
- [ ] `[KMP]` iOS向けHost factoryを用意

## AppNavigationBar

- [ ] `[KMP]` `AppTab` 定義
- [ ] `[KMP]` `selectedTab`入力
- [ ] `[KMP]` `onTabSelected` callback
- [ ] `[KMP]` KMP側でNavigationを実行しない
- [ ] `[KMP]` iOS向けHost factoryを用意

## Artifact

- [ ] `[KMP]` Android artifact更新
- [ ] `[KMP]` XCFramework更新

---

# 4. Milestone KMP-4: Animation Components

## AnimatedExpandableCard

- [ ] `[KMP]` `expanded`を外部Stateとして受け取る
- [ ] `[KMP]` `onExpandedChange`をcallbackで返す
- [ ] `[KMP]` `AnimatedVisibility`を利用
- [ ] `[KMP]` `animateContentSize`を利用
- [ ] `[KMP]` Component内部で画面状態を所有しない

## PulseLoadingButton

- [ ] `[KMP]` `loading`を外部Stateとして受け取る
- [ ] `[KMP]` `onClick` callback
- [ ] `[KMP]` `loading == true`時のみ内部animationを動作
- [ ] `[KMP]` dispose時にCompose animation scopeから外れる設計を確認

## Artifact

- [ ] `[KMP]` Android artifact更新
- [ ] `[KMP]` XCFramework更新

---

# 5. Milestone KMP-5: ScrollableCardList

```kotlin
@Composable
fun ScrollableCardList(
    items: List<ItemCardModel>,
    onItemClick: (String) -> Unit,
)
```

## Tasks

- [ ] `[KMP]` `LazyColumn`実装
- [ ] `[KMP]` `items`描画
- [ ] `[KMP]` stableな`id`をkeyとして扱える設計
- [ ] `[KMP]` Item click callback
- [ ] `[KMP]` 100件で動作
- [ ] `[KMP]` 1,000件で動作
- [ ] `[KMP]` iOS向けHost factory作成
- [ ] `[KMP]` Android artifact更新
- [ ] `[KMP]` XCFramework更新

---

# 6. Milestone KMP-6: Artifact Version Update Test

初回Integration完了後にComponent変更を行い、Native側の更新フローを検証する。

例:

```text
0.1.0
↓
PrimaryButton padding変更
↓
0.1.1
```

## Android

- [ ] `[KMP]` Versionを更新
- [ ] `[KMP]` Local Mavenへpublish

## iOS

- [ ] `[KMP]` XCFrameworkを再生成
- [ ] `[KMP]` Native側が新成果物を識別できるよう更新

## Native確認待ち

- [ ] `[WAIT: ANDROID]` 新versionへの更新成功
- [ ] `[WAIT: IOS]` 新XCFrameworkへの更新成功

---

# 7. KMP Phase 1 完了条件

- [ ] `[KMP]` 全7 Component実装済み
- [ ] `[KMP]` Native StateをKMPが所有していない
- [ ] `[KMP]` Native NavigationをKMPが所有していない
- [ ] `[KMP]` Android artifact生成可能
- [ ] `[KMP]` iOS XCFramework生成可能
- [ ] `[KMP]` iOS公開境界が明確
- [ ] `[KMP]` artifact更新が再現可能
- [ ] `[ANDROID]` 全Component利用確認済み
- [ ] `[IOS]` 全Component利用確認済み
